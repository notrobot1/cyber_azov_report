package androidx.biometric;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.biometric.BiometricPrompt;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class BiometricFragment extends Fragment {
    static final int CANCELED_FROM_CLIENT = 3;
    static final int CANCELED_FROM_INTERNAL = 0;
    static final int CANCELED_FROM_NEGATIVE_BUTTON = 2;
    static final int CANCELED_FROM_USER = 1;
    private static final int DISMISS_INSTANTLY_DELAY_MS = 500;
    private static final String FINGERPRINT_DIALOG_FRAGMENT_TAG = "androidx.biometric.FingerprintDialogFragment";
    private static final int HIDE_DIALOG_DELAY_MS = 2000;
    private static final int REQUEST_CONFIRM_CREDENTIAL = 1;
    private static final int SHOW_PROMPT_DELAY_MS = 600;
    private static final String TAG = "BiometricFragment";
    private Injector mInjector = new DefaultInjector();
    private BiometricViewModel mViewModel;

    /* loaded from: classes.dex */
    public interface Injector {
        Handler getHandler();

        BiometricViewModel getViewModel(Context context);

        boolean isFaceHardwarePresent(Context context);

        boolean isFingerprintHardwarePresent(Context context);

        boolean isIrisHardwarePresent(Context context);
    }

    /* loaded from: classes.dex */
    public static class PromptExecutor implements Executor {
        private final Handler mPromptHandler = new Handler(Looper.getMainLooper());

        PromptExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.mPromptHandler.post(runnable);
        }
    }

    /* loaded from: classes.dex */
    public static class ShowPromptForAuthenticationRunnable implements Runnable {
        private final WeakReference<BiometricFragment> mFragmentRef;

        ShowPromptForAuthenticationRunnable(BiometricFragment biometricFragment) {
            this.mFragmentRef = new WeakReference<>(biometricFragment);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mFragmentRef.get() != null) {
                this.mFragmentRef.get().showPromptForAuthentication();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class StopDelayingPromptRunnable implements Runnable {
        private final WeakReference<BiometricViewModel> mViewModelRef;

        StopDelayingPromptRunnable(BiometricViewModel biometricViewModel) {
            this.mViewModelRef = new WeakReference<>(biometricViewModel);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mViewModelRef.get() != null) {
                this.mViewModelRef.get().setDelayingPrompt(false);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class StopIgnoringCancelRunnable implements Runnable {
        private final WeakReference<BiometricViewModel> mViewModelRef;

        StopIgnoringCancelRunnable(BiometricViewModel biometricViewModel) {
            this.mViewModelRef = new WeakReference<>(biometricViewModel);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mViewModelRef.get() != null) {
                this.mViewModelRef.get().setIgnoringCancel(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class DefaultInjector implements Injector {
        private final Handler mHandler = new Handler(Looper.getMainLooper());

        DefaultInjector() {
        }

        @Override // androidx.biometric.BiometricFragment.Injector
        public Handler getHandler() {
            return this.mHandler;
        }

        @Override // androidx.biometric.BiometricFragment.Injector
        public BiometricViewModel getViewModel(Context context) {
            return BiometricPrompt.getViewModel(context);
        }

        @Override // androidx.biometric.BiometricFragment.Injector
        public boolean isFingerprintHardwarePresent(Context context) {
            return PackageUtils.hasSystemFeatureFingerprint(context);
        }

        @Override // androidx.biometric.BiometricFragment.Injector
        public boolean isFaceHardwarePresent(Context context) {
            return PackageUtils.hasSystemFeatureFace(context);
        }

        @Override // androidx.biometric.BiometricFragment.Injector
        public boolean isIrisHardwarePresent(Context context) {
            return PackageUtils.hasSystemFeatureIris(context);
        }
    }

    public static BiometricFragment newInstance() {
        return new BiometricFragment();
    }

    static BiometricFragment newInstance(Injector injector) {
        BiometricFragment biometricFragment = new BiometricFragment();
        biometricFragment.mInjector = injector;
        return biometricFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        connectViewModel();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        BiometricViewModel viewModel = getViewModel();
        if (Build.VERSION.SDK_INT != 29 || viewModel == null || !AuthenticatorUtils.isDeviceCredentialAllowed(viewModel.getAllowedAuthenticators())) {
            return;
        }
        viewModel.setIgnoringCancel(true);
        this.mInjector.getHandler().postDelayed(new StopIgnoringCancelRunnable(viewModel), 250L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        BiometricViewModel viewModel = getViewModel();
        if (Build.VERSION.SDK_INT >= 29 || viewModel == null || viewModel.isConfirmingDeviceCredential() || isChangingConfigurations()) {
            return;
        }
        cancelAuthentication(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            BiometricViewModel viewModel = getViewModel();
            if (viewModel != null) {
                viewModel.setConfirmingDeviceCredential(false);
            }
            handleConfirmCredentialResult(i2);
        }
    }

    private BiometricViewModel getViewModel() {
        if (this.mViewModel == null) {
            this.mViewModel = this.mInjector.getViewModel(BiometricPrompt.getHostActivityOrContext(this));
        }
        return this.mViewModel;
    }

    private void connectViewModel() {
        final BiometricViewModel viewModel = getViewModel();
        if (viewModel != null) {
            viewModel.setClientActivity(getActivity());
            viewModel.getAuthenticationResult().observe(this, new Observer() { // from class: androidx.biometric.BiometricFragment$$ExternalSyntheticLambda1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BiometricFragment.this.m0lambda$connectViewModel$0$androidxbiometricBiometricFragment(viewModel, (BiometricPrompt.AuthenticationResult) obj);
                }
            });
            viewModel.getAuthenticationError().observe(this, new Observer() { // from class: androidx.biometric.BiometricFragment$$ExternalSyntheticLambda0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BiometricFragment.this.m1lambda$connectViewModel$1$androidxbiometricBiometricFragment(viewModel, (BiometricErrorData) obj);
                }
            });
            viewModel.getAuthenticationHelpMessage().observe(this, new Observer() { // from class: androidx.biometric.BiometricFragment$$ExternalSyntheticLambda5
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BiometricFragment.this.m2lambda$connectViewModel$2$androidxbiometricBiometricFragment(viewModel, (CharSequence) obj);
                }
            });
            viewModel.isAuthenticationFailurePending().observe(this, new Observer() { // from class: androidx.biometric.BiometricFragment$$ExternalSyntheticLambda2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BiometricFragment.this.m3lambda$connectViewModel$3$androidxbiometricBiometricFragment(viewModel, (Boolean) obj);
                }
            });
            viewModel.isNegativeButtonPressPending().observe(this, new Observer() { // from class: androidx.biometric.BiometricFragment$$ExternalSyntheticLambda3
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BiometricFragment.this.m4lambda$connectViewModel$4$androidxbiometricBiometricFragment(viewModel, (Boolean) obj);
                }
            });
            viewModel.isFingerprintDialogCancelPending().observe(this, new Observer() { // from class: androidx.biometric.BiometricFragment$$ExternalSyntheticLambda4
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BiometricFragment.this.m5lambda$connectViewModel$5$androidxbiometricBiometricFragment(viewModel, (Boolean) obj);
                }
            });
        }
    }

    /* renamed from: lambda$connectViewModel$0$androidx-biometric-BiometricFragment */
    public /* synthetic */ void m0lambda$connectViewModel$0$androidxbiometricBiometricFragment(BiometricViewModel biometricViewModel, BiometricPrompt.AuthenticationResult authenticationResult) {
        if (authenticationResult != null) {
            onAuthenticationSucceeded(authenticationResult);
            biometricViewModel.setAuthenticationResult(null);
        }
    }

    /* renamed from: lambda$connectViewModel$1$androidx-biometric-BiometricFragment */
    public /* synthetic */ void m1lambda$connectViewModel$1$androidxbiometricBiometricFragment(BiometricViewModel biometricViewModel, BiometricErrorData biometricErrorData) {
        if (biometricErrorData != null) {
            onAuthenticationError(biometricErrorData.getErrorCode(), biometricErrorData.getErrorMessage());
            biometricViewModel.setAuthenticationError(null);
        }
    }

    /* renamed from: lambda$connectViewModel$2$androidx-biometric-BiometricFragment */
    public /* synthetic */ void m2lambda$connectViewModel$2$androidxbiometricBiometricFragment(BiometricViewModel biometricViewModel, CharSequence charSequence) {
        if (charSequence != null) {
            onAuthenticationHelp(charSequence);
            biometricViewModel.setAuthenticationError(null);
        }
    }

    /* renamed from: lambda$connectViewModel$3$androidx-biometric-BiometricFragment */
    public /* synthetic */ void m3lambda$connectViewModel$3$androidxbiometricBiometricFragment(BiometricViewModel biometricViewModel, Boolean bool) {
        if (bool.booleanValue()) {
            onAuthenticationFailed();
            biometricViewModel.setAuthenticationFailurePending(false);
        }
    }

    /* renamed from: lambda$connectViewModel$4$androidx-biometric-BiometricFragment */
    public /* synthetic */ void m4lambda$connectViewModel$4$androidxbiometricBiometricFragment(BiometricViewModel biometricViewModel, Boolean bool) {
        if (bool.booleanValue()) {
            if (isManagingDeviceCredentialButton()) {
                onDeviceCredentialButtonPressed();
            } else {
                onCancelButtonPressed();
            }
            biometricViewModel.setNegativeButtonPressPending(false);
        }
    }

    /* renamed from: lambda$connectViewModel$5$androidx-biometric-BiometricFragment */
    public /* synthetic */ void m5lambda$connectViewModel$5$androidxbiometricBiometricFragment(BiometricViewModel biometricViewModel, Boolean bool) {
        if (bool.booleanValue()) {
            cancelAuthentication(1);
            dismiss();
            biometricViewModel.setFingerprintDialogCancelPending(false);
        }
    }

    public void authenticate(BiometricPrompt.PromptInfo promptInfo, BiometricPrompt.CryptoObject cryptoObject) {
        if (BiometricPrompt.getHostActivityOrContext(this) == null) {
            Log.e(TAG, "Not launching prompt. Client context was null.");
            return;
        }
        BiometricViewModel viewModel = getViewModel();
        if (viewModel == null) {
            Log.e(TAG, "Not launching prompt. View model was null.");
            return;
        }
        viewModel.setPromptInfo(promptInfo);
        int consolidatedAuthenticators = AuthenticatorUtils.getConsolidatedAuthenticators(promptInfo, cryptoObject);
        if (Build.VERSION.SDK_INT >= 23 && Build.VERSION.SDK_INT < 30 && consolidatedAuthenticators == 15 && cryptoObject == null) {
            viewModel.setCryptoObject(CryptoObjectUtils.createFakeCryptoObject());
        } else {
            viewModel.setCryptoObject(cryptoObject);
        }
        if (isManagingDeviceCredentialButton()) {
            viewModel.setNegativeButtonTextOverride(getString(R.string.confirm_device_credential_password));
        } else {
            viewModel.setNegativeButtonTextOverride(null);
        }
        if (Build.VERSION.SDK_INT >= 21 && isKeyguardManagerNeededForCredential()) {
            viewModel.setAwaitingResult(true);
            launchConfirmCredentialActivity();
        } else if (viewModel.isDelayingPrompt()) {
            this.mInjector.getHandler().postDelayed(new ShowPromptForAuthenticationRunnable(this), 600L);
        } else {
            showPromptForAuthentication();
        }
    }

    void showPromptForAuthentication() {
        BiometricViewModel viewModel = getViewModel();
        if (viewModel == null || viewModel.isPromptShowing()) {
            return;
        }
        if (getContext() == null) {
            Log.w(TAG, "Not showing biometric prompt. Context is null.");
            return;
        }
        viewModel.setPromptShowing(true);
        viewModel.setAwaitingResult(true);
        if (Build.VERSION.SDK_INT >= 21 && isKeyguardManagerNeededForBiometricAndCredential()) {
            launchConfirmCredentialActivity();
        } else if (isUsingFingerprintDialog()) {
            showFingerprintDialogForAuthentication();
        } else {
            showBiometricPromptForAuthentication();
        }
    }

    private void showFingerprintDialogForAuthentication() {
        Context applicationContext = requireContext().getApplicationContext();
        FingerprintManagerCompat from = FingerprintManagerCompat.from(applicationContext);
        int checkForFingerprintPreAuthenticationErrors = checkForFingerprintPreAuthenticationErrors(from);
        if (checkForFingerprintPreAuthenticationErrors != 0) {
            m6x21f86f4c(checkForFingerprintPreAuthenticationErrors, ErrorUtils.getFingerprintErrorString(applicationContext, checkForFingerprintPreAuthenticationErrors));
        } else if (Build.VERSION.SDK_INT < 19) {
            Log.e(TAG, "Unable to show fingerprint dialog on API <19.");
        } else {
            final BiometricViewModel viewModel = getViewModel();
            if (viewModel == null || !isAdded()) {
                return;
            }
            viewModel.setFingerprintDialogDismissedInstantly(true);
            if (!DeviceUtils.shouldHideFingerprintDialog(applicationContext, Build.MODEL)) {
                this.mInjector.getHandler().postDelayed(new Runnable() { // from class: androidx.biometric.BiometricFragment$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        BiometricFragment.lambda$showFingerprintDialogForAuthentication$6(BiometricViewModel.this);
                    }
                }, 500L);
                FingerprintDialogFragment.newInstance().show(getParentFragmentManager(), FINGERPRINT_DIALOG_FRAGMENT_TAG);
            }
            viewModel.setCanceledFrom(0);
            authenticateWithFingerprint(from, applicationContext);
        }
    }

    public static /* synthetic */ void lambda$showFingerprintDialogForAuthentication$6(BiometricViewModel biometricViewModel) {
        biometricViewModel.setFingerprintDialogDismissedInstantly(false);
    }

    private void showBiometricPromptForAuthentication() {
        BiometricPrompt.Builder createPromptBuilder = Api28Impl.createPromptBuilder(requireContext().getApplicationContext());
        BiometricViewModel viewModel = getViewModel();
        if (viewModel == null) {
            Log.e(TAG, "Not showing biometric prompt. View model was null.");
            return;
        }
        CharSequence title = viewModel.getTitle();
        CharSequence subtitle = viewModel.getSubtitle();
        CharSequence description = viewModel.getDescription();
        if (title != null) {
            Api28Impl.setTitle(createPromptBuilder, title);
        }
        if (subtitle != null) {
            Api28Impl.setSubtitle(createPromptBuilder, subtitle);
        }
        if (description != null) {
            Api28Impl.setDescription(createPromptBuilder, description);
        }
        CharSequence negativeButtonText = viewModel.getNegativeButtonText();
        if (!TextUtils.isEmpty(negativeButtonText)) {
            Api28Impl.setNegativeButton(createPromptBuilder, negativeButtonText, viewModel.getClientExecutor(), viewModel.getNegativeButtonListener());
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.setConfirmationRequired(createPromptBuilder, viewModel.isConfirmationRequired());
        }
        int allowedAuthenticators = viewModel.getAllowedAuthenticators();
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setAllowedAuthenticators(createPromptBuilder, allowedAuthenticators);
        } else if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.setDeviceCredentialAllowed(createPromptBuilder, AuthenticatorUtils.isDeviceCredentialAllowed(allowedAuthenticators));
        }
        authenticateWithBiometricPrompt(Api28Impl.buildPrompt(createPromptBuilder), getContext());
    }

    void authenticateWithFingerprint(FingerprintManagerCompat fingerprintManagerCompat, Context context) {
        BiometricViewModel viewModel = getViewModel();
        if (viewModel == null) {
            Log.e(TAG, "Not showing fingerprint dialog. View model was null.");
            return;
        }
        try {
            fingerprintManagerCompat.authenticate(CryptoObjectUtils.wrapForFingerprintManager(viewModel.getCryptoObject()), 0, viewModel.getCancellationSignalProvider().getFingerprintCancellationSignal(), viewModel.getAuthenticationCallbackProvider().getFingerprintCallback(), null);
        } catch (NullPointerException e) {
            Log.e(TAG, "Got NPE while authenticating with fingerprint.", e);
            m6x21f86f4c(1, ErrorUtils.getFingerprintErrorString(context, 1));
        }
    }

    void authenticateWithBiometricPrompt(android.hardware.biometrics.BiometricPrompt biometricPrompt, Context context) {
        BiometricViewModel viewModel = getViewModel();
        if (viewModel == null) {
            Log.e(TAG, "Not authenticating with biometric prompt. View model was null.");
            return;
        }
        BiometricPrompt.CryptoObject wrapForBiometricPrompt = CryptoObjectUtils.wrapForBiometricPrompt(viewModel.getCryptoObject());
        CancellationSignal biometricCancellationSignal = viewModel.getCancellationSignalProvider().getBiometricCancellationSignal();
        PromptExecutor promptExecutor = new PromptExecutor();
        BiometricPrompt.AuthenticationCallback biometricCallback = viewModel.getAuthenticationCallbackProvider().getBiometricCallback();
        try {
            if (wrapForBiometricPrompt == null) {
                Api28Impl.authenticate(biometricPrompt, biometricCancellationSignal, promptExecutor, biometricCallback);
            } else {
                Api28Impl.authenticate(biometricPrompt, wrapForBiometricPrompt, biometricCancellationSignal, promptExecutor, biometricCallback);
            }
        } catch (NullPointerException e) {
            Log.e(TAG, "Got NPE while authenticating with biometric prompt.", e);
            m6x21f86f4c(1, context != null ? context.getString(R.string.default_error_msg) : "");
        }
    }

    public void cancelAuthentication(int i) {
        BiometricViewModel viewModel = getViewModel();
        if (viewModel == null) {
            Log.e(TAG, "Unable to cancel authentication. View model was null.");
        } else if (i != 3 && viewModel.isIgnoringCancel()) {
        } else {
            if (isUsingFingerprintDialog()) {
                viewModel.setCanceledFrom(i);
                if (i == 1) {
                    sendErrorToClient(10, ErrorUtils.getFingerprintErrorString(getContext(), 10));
                }
            }
            viewModel.getCancellationSignalProvider().cancel();
        }
    }

    void dismiss() {
        dismissFingerprintDialog();
        BiometricViewModel viewModel = getViewModel();
        if (viewModel != null) {
            viewModel.setPromptShowing(false);
        }
        if (viewModel == null || (!viewModel.isConfirmingDeviceCredential() && isAdded())) {
            getParentFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        }
        Context context = getContext();
        if (context == null || !DeviceUtils.shouldDelayShowingPrompt(context, Build.MODEL)) {
            return;
        }
        if (viewModel != null) {
            viewModel.setDelayingPrompt(true);
        }
        this.mInjector.getHandler().postDelayed(new StopDelayingPromptRunnable(this.mViewModel), 600L);
    }

    private void dismissFingerprintDialog() {
        BiometricViewModel viewModel = getViewModel();
        if (viewModel != null) {
            viewModel.setPromptShowing(false);
        }
        if (isAdded()) {
            FragmentManager parentFragmentManager = getParentFragmentManager();
            FingerprintDialogFragment fingerprintDialogFragment = (FingerprintDialogFragment) parentFragmentManager.findFragmentByTag(FINGERPRINT_DIALOG_FRAGMENT_TAG);
            if (fingerprintDialogFragment == null) {
                return;
            }
            if (fingerprintDialogFragment.isAdded()) {
                fingerprintDialogFragment.dismissAllowingStateLoss();
            } else {
                parentFragmentManager.beginTransaction().remove(fingerprintDialogFragment).commitAllowingStateLoss();
            }
        }
    }

    void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
        sendSuccessAndDismiss(authenticationResult);
    }

    void onAuthenticationError(final int i, final CharSequence charSequence) {
        if (!ErrorUtils.isKnownError(i)) {
            i = 8;
        }
        BiometricViewModel viewModel = getViewModel();
        if (viewModel == null) {
            Log.e(TAG, "Unable to handle authentication error. View model was null.");
            return;
        }
        Context context = getContext();
        if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 29 && ErrorUtils.isLockoutError(i) && context != null && KeyguardUtils.isDeviceSecuredWithCredential(context) && AuthenticatorUtils.isDeviceCredentialAllowed(viewModel.getAllowedAuthenticators())) {
            launchConfirmCredentialActivity();
        } else if (!isUsingFingerprintDialog()) {
            if (charSequence == null) {
                charSequence = getString(R.string.default_error_msg) + " " + i;
            }
            m6x21f86f4c(i, charSequence);
        } else {
            if (charSequence == null) {
                charSequence = ErrorUtils.getFingerprintErrorString(getContext(), i);
            }
            if (i == 5) {
                int canceledFrom = viewModel.getCanceledFrom();
                if (canceledFrom == 0 || canceledFrom == 3) {
                    sendErrorToClient(i, charSequence);
                }
                dismiss();
                return;
            }
            if (viewModel.isFingerprintDialogDismissedInstantly()) {
                m6x21f86f4c(i, charSequence);
            } else {
                showFingerprintErrorMessage(charSequence);
                this.mInjector.getHandler().postDelayed(new Runnable() { // from class: androidx.biometric.BiometricFragment$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        BiometricFragment.this.m6x21f86f4c(i, charSequence);
                    }
                }, getDismissDialogDelay());
            }
            viewModel.setFingerprintDialogDismissedInstantly(true);
        }
    }

    void onAuthenticationHelp(CharSequence charSequence) {
        if (isUsingFingerprintDialog()) {
            showFingerprintErrorMessage(charSequence);
        }
    }

    void onAuthenticationFailed() {
        if (isUsingFingerprintDialog()) {
            showFingerprintErrorMessage(getString(R.string.fingerprint_not_recognized));
        }
        sendFailureToClient();
    }

    void onDeviceCredentialButtonPressed() {
        if (Build.VERSION.SDK_INT < 21) {
            Log.e(TAG, "Failed to check device credential. Not supported prior to API 21.");
        } else {
            launchConfirmCredentialActivity();
        }
    }

    void onCancelButtonPressed() {
        BiometricViewModel viewModel = getViewModel();
        CharSequence negativeButtonText = viewModel != null ? viewModel.getNegativeButtonText() : null;
        if (negativeButtonText == null) {
            negativeButtonText = getString(R.string.default_error_msg);
        }
        m6x21f86f4c(13, negativeButtonText);
        cancelAuthentication(2);
    }

    private void launchConfirmCredentialActivity() {
        Context hostActivityOrContext = BiometricPrompt.getHostActivityOrContext(this);
        if (hostActivityOrContext == null) {
            Log.e(TAG, "Failed to check device credential. Client context not found.");
            return;
        }
        BiometricViewModel viewModel = getViewModel();
        if (viewModel == null) {
            Log.e(TAG, "Failed to check device credential. View model was null.");
            return;
        }
        KeyguardManager keyguardManager = KeyguardUtils.getKeyguardManager(hostActivityOrContext);
        if (keyguardManager == null) {
            m6x21f86f4c(12, getString(R.string.generic_error_no_keyguard));
            return;
        }
        CharSequence title = viewModel.getTitle();
        CharSequence subtitle = viewModel.getSubtitle();
        CharSequence description = viewModel.getDescription();
        if (subtitle == null) {
            subtitle = description;
        }
        Intent createConfirmDeviceCredentialIntent = Api21Impl.createConfirmDeviceCredentialIntent(keyguardManager, title, subtitle);
        if (createConfirmDeviceCredentialIntent == null) {
            m6x21f86f4c(14, getString(R.string.generic_error_no_device_credential));
            return;
        }
        viewModel.setConfirmingDeviceCredential(true);
        if (isUsingFingerprintDialog()) {
            dismissFingerprintDialog();
        }
        createConfirmDeviceCredentialIntent.setFlags(134742016);
        startActivityForResult(createConfirmDeviceCredentialIntent, 1);
    }

    private void handleConfirmCredentialResult(int i) {
        int i2 = -1;
        if (i == -1) {
            BiometricViewModel viewModel = getViewModel();
            if (viewModel == null || !viewModel.isUsingKeyguardManagerForBiometricAndCredential()) {
                i2 = 1;
            } else {
                viewModel.setUsingKeyguardManagerForBiometricAndCredential(false);
            }
            sendSuccessAndDismiss(new BiometricPrompt.AuthenticationResult(null, i2));
            return;
        }
        m6x21f86f4c(10, getString(R.string.generic_error_user_canceled));
    }

    private void showFingerprintErrorMessage(CharSequence charSequence) {
        BiometricViewModel viewModel = getViewModel();
        if (viewModel != null) {
            if (charSequence == null) {
                charSequence = getString(R.string.default_error_msg);
            }
            viewModel.setFingerprintDialogState(2);
            viewModel.setFingerprintDialogHelpMessage(charSequence);
        }
    }

    private void sendSuccessAndDismiss(BiometricPrompt.AuthenticationResult authenticationResult) {
        sendSuccessToClient(authenticationResult);
        dismiss();
    }

    /* renamed from: sendErrorAndDismiss */
    public void m6x21f86f4c(int i, CharSequence charSequence) {
        sendErrorToClient(i, charSequence);
        dismiss();
    }

    private void sendSuccessToClient(final BiometricPrompt.AuthenticationResult authenticationResult) {
        final BiometricViewModel viewModel = getViewModel();
        if (viewModel == null) {
            Log.e(TAG, "Unable to send success to client. View model was null.");
        } else if (!viewModel.isAwaitingResult()) {
            Log.w(TAG, "Success not sent to client. Client is not awaiting a result.");
        } else {
            viewModel.setAwaitingResult(false);
            viewModel.getClientExecutor().execute(new Runnable() { // from class: androidx.biometric.BiometricFragment.1
                {
                    BiometricFragment.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    viewModel.getClientCallback().onAuthenticationSucceeded(authenticationResult);
                }
            });
        }
    }

    private void sendErrorToClient(final int i, final CharSequence charSequence) {
        final BiometricViewModel viewModel = getViewModel();
        if (viewModel == null) {
            Log.e(TAG, "Unable to send error to client. View model was null.");
        } else if (viewModel.isConfirmingDeviceCredential()) {
            Log.v(TAG, "Error not sent to client. User is confirming their device credential.");
        } else if (!viewModel.isAwaitingResult()) {
            Log.w(TAG, "Error not sent to client. Client is not awaiting a result.");
        } else {
            viewModel.setAwaitingResult(false);
            viewModel.getClientExecutor().execute(new Runnable() { // from class: androidx.biometric.BiometricFragment.2
                {
                    BiometricFragment.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    viewModel.getClientCallback().onAuthenticationError(i, charSequence);
                }
            });
        }
    }

    private void sendFailureToClient() {
        final BiometricViewModel viewModel = getViewModel();
        if (viewModel == null) {
            Log.e(TAG, "Unable to send failure to client. View model was null.");
        } else if (!viewModel.isAwaitingResult()) {
            Log.w(TAG, "Failure not sent to client. Client is not awaiting a result.");
        } else {
            viewModel.getClientExecutor().execute(new Runnable() { // from class: androidx.biometric.BiometricFragment.3
                {
                    BiometricFragment.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    viewModel.getClientCallback().onAuthenticationFailed();
                }
            });
        }
    }

    private static int checkForFingerprintPreAuthenticationErrors(FingerprintManagerCompat fingerprintManagerCompat) {
        if (!fingerprintManagerCompat.isHardwareDetected()) {
            return 12;
        }
        return !fingerprintManagerCompat.hasEnrolledFingerprints() ? 11 : 0;
    }

    boolean isManagingDeviceCredentialButton() {
        BiometricViewModel viewModel = getViewModel();
        return Build.VERSION.SDK_INT <= 28 && viewModel != null && AuthenticatorUtils.isDeviceCredentialAllowed(viewModel.getAllowedAuthenticators());
    }

    private boolean isUsingFingerprintDialog() {
        return Build.VERSION.SDK_INT < 28 || isFingerprintDialogNeededForCrypto() || isFingerprintDialogNeededForErrorHandling();
    }

    private boolean isFingerprintDialogNeededForCrypto() {
        Context hostActivityOrContext = BiometricPrompt.getHostActivityOrContext(this);
        BiometricViewModel viewModel = getViewModel();
        return (hostActivityOrContext == null || viewModel == null || viewModel.getCryptoObject() == null || !DeviceUtils.shouldUseFingerprintForCrypto(hostActivityOrContext, Build.MANUFACTURER, Build.MODEL)) ? false : true;
    }

    private boolean isFingerprintDialogNeededForErrorHandling() {
        return Build.VERSION.SDK_INT == 28 && !this.mInjector.isFingerprintHardwarePresent(getContext());
    }

    private boolean isKeyguardManagerNeededForCredential() {
        Context context = getContext();
        if (Build.VERSION.SDK_INT != 29 || this.mInjector.isFingerprintHardwarePresent(context) || this.mInjector.isFaceHardwarePresent(context) || this.mInjector.isIrisHardwarePresent(context)) {
            return isManagingDeviceCredentialButton() && BiometricManager.from(context).canAuthenticate(255) != 0;
        }
        return true;
    }

    private boolean isKeyguardManagerNeededForBiometricAndCredential() {
        Context context = getContext();
        if (context == null || !DeviceUtils.shouldUseKeyguardManagerForBiometricAndCredential(context, Build.MANUFACTURER)) {
            return false;
        }
        BiometricViewModel viewModel = getViewModel();
        int allowedAuthenticators = viewModel != null ? viewModel.getAllowedAuthenticators() : 0;
        if (viewModel == null || !AuthenticatorUtils.isWeakBiometricAllowed(allowedAuthenticators) || !AuthenticatorUtils.isDeviceCredentialAllowed(allowedAuthenticators)) {
            return false;
        }
        viewModel.setUsingKeyguardManagerForBiometricAndCredential(true);
        return true;
    }

    private boolean isChangingConfigurations() {
        FragmentActivity activity = getActivity();
        return activity != null && activity.isChangingConfigurations();
    }

    private int getDismissDialogDelay() {
        Context context = getContext();
        if (context == null || !DeviceUtils.shouldHideFingerprintDialog(context, Build.MODEL)) {
            return HIDE_DIALOG_DELAY_MS;
        }
        return 0;
    }

    /* loaded from: classes.dex */
    public static class Api30Impl {
        private Api30Impl() {
        }

        static void setAllowedAuthenticators(BiometricPrompt.Builder builder, int i) {
            builder.setAllowedAuthenticators(i);
        }
    }

    /* loaded from: classes.dex */
    public static class Api29Impl {
        private Api29Impl() {
        }

        static void setConfirmationRequired(BiometricPrompt.Builder builder, boolean z) {
            builder.setConfirmationRequired(z);
        }

        static void setDeviceCredentialAllowed(BiometricPrompt.Builder builder, boolean z) {
            builder.setDeviceCredentialAllowed(z);
        }
    }

    /* loaded from: classes.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        static BiometricPrompt.Builder createPromptBuilder(Context context) {
            return new BiometricPrompt.Builder(context);
        }

        static void setTitle(BiometricPrompt.Builder builder, CharSequence charSequence) {
            builder.setTitle(charSequence);
        }

        static void setSubtitle(BiometricPrompt.Builder builder, CharSequence charSequence) {
            builder.setSubtitle(charSequence);
        }

        static void setDescription(BiometricPrompt.Builder builder, CharSequence charSequence) {
            builder.setDescription(charSequence);
        }

        static void setNegativeButton(BiometricPrompt.Builder builder, CharSequence charSequence, Executor executor, DialogInterface.OnClickListener onClickListener) {
            builder.setNegativeButton(charSequence, executor, onClickListener);
        }

        static android.hardware.biometrics.BiometricPrompt buildPrompt(BiometricPrompt.Builder builder) {
            return builder.build();
        }

        static void authenticate(android.hardware.biometrics.BiometricPrompt biometricPrompt, CancellationSignal cancellationSignal, Executor executor, BiometricPrompt.AuthenticationCallback authenticationCallback) {
            biometricPrompt.authenticate(cancellationSignal, executor, authenticationCallback);
        }

        static void authenticate(android.hardware.biometrics.BiometricPrompt biometricPrompt, BiometricPrompt.CryptoObject cryptoObject, CancellationSignal cancellationSignal, Executor executor, BiometricPrompt.AuthenticationCallback authenticationCallback) {
            biometricPrompt.authenticate(cryptoObject, cancellationSignal, executor, authenticationCallback);
        }
    }

    /* loaded from: classes.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        static Intent createConfirmDeviceCredentialIntent(KeyguardManager keyguardManager, CharSequence charSequence, CharSequence charSequence2) {
            return keyguardManager.createConfirmDeviceCredentialIntent(charSequence, charSequence2);
        }
    }
}