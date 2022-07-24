package androidx.biometric.auth;

import android.os.Handler;
import android.os.Looper;
import androidx.biometric.BiometricPrompt;
import androidx.biometric.BiometricViewModel;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class AuthPromptUtils {
    private AuthPromptUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AuthPrompt startAuthentication(AuthPromptHost authPromptHost, BiometricPrompt.PromptInfo promptInfo, BiometricPrompt.CryptoObject cryptoObject, Executor executor, AuthPromptCallback authPromptCallback) {
        BiometricPrompt createBiometricPrompt = createBiometricPrompt(authPromptHost, executor, authPromptCallback);
        if (cryptoObject == null) {
            createBiometricPrompt.authenticate(promptInfo);
        } else {
            createBiometricPrompt.authenticate(promptInfo, cryptoObject);
        }
        return new AuthPromptWrapper(createBiometricPrompt);
    }

    private static BiometricPrompt createBiometricPrompt(AuthPromptHost authPromptHost, Executor executor, AuthPromptCallback authPromptCallback) {
        if (executor == null) {
            executor = new DefaultExecutor();
        }
        if (authPromptHost.getActivity() != null) {
            return new BiometricPrompt(authPromptHost.getActivity(), executor, wrapCallback(authPromptCallback, new ViewModelProvider(authPromptHost.getActivity())));
        } else if (authPromptHost.getFragment() != null && authPromptHost.getFragment().getActivity() != null) {
            return new BiometricPrompt(authPromptHost.getFragment(), executor, wrapCallback(authPromptCallback, new ViewModelProvider(authPromptHost.getFragment().getActivity())));
        } else {
            throw new IllegalArgumentException("AuthPromptHost must contain a FragmentActivity or an attached Fragment.");
        }
    }

    private static AuthenticationCallbackWrapper wrapCallback(AuthPromptCallback authPromptCallback, ViewModelProvider viewModelProvider) {
        return new AuthenticationCallbackWrapper(authPromptCallback, (BiometricViewModel) viewModelProvider.get(BiometricViewModel.class));
    }

    /* loaded from: classes.dex */
    private static class AuthPromptWrapper implements AuthPrompt {
        private final WeakReference<BiometricPrompt> mBiometricPromptRef;

        AuthPromptWrapper(BiometricPrompt biometricPrompt) {
            this.mBiometricPromptRef = new WeakReference<>(biometricPrompt);
        }

        @Override // androidx.biometric.auth.AuthPrompt
        public void cancelAuthentication() {
            if (this.mBiometricPromptRef.get() != null) {
                this.mBiometricPromptRef.get().cancelAuthentication();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class DefaultExecutor implements Executor {
        private final Handler mHandler = new Handler(Looper.getMainLooper());

        DefaultExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.mHandler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AuthenticationCallbackWrapper extends BiometricPrompt.AuthenticationCallback {
        private final AuthPromptCallback mClientCallback;
        private final WeakReference<BiometricViewModel> mViewModelRef;

        AuthenticationCallbackWrapper(AuthPromptCallback authPromptCallback, BiometricViewModel biometricViewModel) {
            this.mClientCallback = authPromptCallback;
            this.mViewModelRef = new WeakReference<>(biometricViewModel);
        }

        @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationError(int i, CharSequence charSequence) {
            this.mClientCallback.onAuthenticationError(getActivity(this.mViewModelRef), i, charSequence);
        }

        @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
            this.mClientCallback.onAuthenticationSucceeded(getActivity(this.mViewModelRef), authenticationResult);
        }

        @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationFailed() {
            this.mClientCallback.onAuthenticationFailed(getActivity(this.mViewModelRef));
        }

        private static FragmentActivity getActivity(WeakReference<BiometricViewModel> weakReference) {
            if (weakReference.get() != null) {
                return weakReference.get().getClientActivity();
            }
            return null;
        }
    }
}