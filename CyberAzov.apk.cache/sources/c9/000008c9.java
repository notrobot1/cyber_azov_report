package androidx.biometric;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.biometrics.BiometricManager;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.util.Log;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class BiometricManager {
    private static final int AUTH_MODALITY_CREDENTIAL = 1;
    private static final int AUTH_MODALITY_FACE = 8;
    private static final int AUTH_MODALITY_FINGERPRINT = 4;
    private static final int AUTH_MODALITY_NONE = 0;
    private static final int AUTH_MODALITY_UNKNOWN_BIOMETRIC = 2;
    public static final int BIOMETRIC_ERROR_HW_UNAVAILABLE = 1;
    public static final int BIOMETRIC_ERROR_NONE_ENROLLED = 11;
    public static final int BIOMETRIC_ERROR_NO_HARDWARE = 12;
    public static final int BIOMETRIC_ERROR_SECURITY_UPDATE_REQUIRED = 15;
    public static final int BIOMETRIC_ERROR_UNSUPPORTED = -2;
    public static final int BIOMETRIC_STATUS_UNKNOWN = -1;
    public static final int BIOMETRIC_SUCCESS = 0;
    private static final String TAG = "BiometricManager";
    private final android.hardware.biometrics.BiometricManager mBiometricManager;
    private final FingerprintManagerCompat mFingerprintManager;
    private final Injector mInjector;

    /* loaded from: classes.dex */
    public interface Authenticators {
        public static final int BIOMETRIC_STRONG = 15;
        public static final int BIOMETRIC_WEAK = 255;
        public static final int DEVICE_CREDENTIAL = 32768;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Injector {
        android.hardware.biometrics.BiometricManager getBiometricManager();

        FingerprintManagerCompat getFingerprintManager();

        Resources getResources();

        boolean isDeviceSecurable();

        boolean isDeviceSecuredWithCredential();

        boolean isFaceHardwarePresent();

        boolean isFingerprintHardwarePresent();

        boolean isIrisHardwarePresent();

        boolean isStrongBiometricGuaranteed();
    }

    /* loaded from: classes.dex */
    public static class Strings {
        private final BiometricManager.Strings mStrings;
        private final StringsCompat mStringsCompat;

        Strings(BiometricManager.Strings strings) {
            this.mStrings = strings;
            this.mStringsCompat = null;
        }

        Strings(StringsCompat stringsCompat) {
            this.mStrings = null;
            this.mStringsCompat = stringsCompat;
        }

        public CharSequence getButtonLabel() {
            BiometricManager.Strings strings;
            if (Build.VERSION.SDK_INT >= 31 && (strings = this.mStrings) != null) {
                return Api31Impl.getButtonLabel(strings);
            }
            StringsCompat stringsCompat = this.mStringsCompat;
            if (stringsCompat != null) {
                return stringsCompat.getButtonLabel();
            }
            Log.e(BiometricManager.TAG, "Failure in Strings.getButtonLabel(). No available string provider.");
            return null;
        }

        public CharSequence getPromptMessage() {
            BiometricManager.Strings strings;
            if (Build.VERSION.SDK_INT >= 31 && (strings = this.mStrings) != null) {
                return Api31Impl.getPromptMessage(strings);
            }
            StringsCompat stringsCompat = this.mStringsCompat;
            if (stringsCompat != null) {
                return stringsCompat.getPromptMessage();
            }
            Log.e(BiometricManager.TAG, "Failure in Strings.getPromptMessage(). No available string provider.");
            return null;
        }

        public CharSequence getSettingName() {
            BiometricManager.Strings strings;
            if (Build.VERSION.SDK_INT >= 31 && (strings = this.mStrings) != null) {
                return Api31Impl.getSettingName(strings);
            }
            StringsCompat stringsCompat = this.mStringsCompat;
            if (stringsCompat != null) {
                return stringsCompat.getSettingName();
            }
            Log.e(BiometricManager.TAG, "Failure in Strings.getSettingName(). No available string provider.");
            return null;
        }
    }

    /* loaded from: classes.dex */
    private class StringsCompat {
        private final int mAuthenticators;
        private final int mPossibleModalities;
        private final Resources mResources;

        StringsCompat(Resources resources, int i, boolean z, boolean z2, boolean z3, boolean z4) {
            this.mResources = resources;
            this.mAuthenticators = i;
            int i2 = (!z4 || !AuthenticatorUtils.isDeviceCredentialAllowed(i)) ? 0 : 1;
            if (AuthenticatorUtils.isSomeBiometricAllowed(i)) {
                i2 = z ? i2 | 4 : i2;
                i2 = z2 ? i2 | 8 : i2;
                if (z3) {
                    i2 |= 2;
                }
            }
            this.mPossibleModalities = i2;
        }

        CharSequence getButtonLabel() {
            if (BiometricManager.this.canAuthenticate(AuthenticatorUtils.getBiometricAuthenticators(this.mAuthenticators)) == 0) {
                int i = this.mPossibleModalities & (-2);
                if (i == 4) {
                    return this.mResources.getString(R.string.use_fingerprint_label);
                }
                if (i == 8) {
                    return this.mResources.getString(R.string.use_face_label);
                }
                return this.mResources.getString(R.string.use_biometric_label);
            } else if ((this.mPossibleModalities & 1) == 0) {
                return null;
            } else {
                return this.mResources.getString(R.string.use_screen_lock_label);
            }
        }

        CharSequence getPromptMessage() {
            int i;
            if (BiometricManager.this.canAuthenticate(AuthenticatorUtils.getBiometricAuthenticators(this.mAuthenticators)) == 0) {
                int i2 = this.mPossibleModalities & (-2);
                if (i2 != 4) {
                    if (i2 == 8) {
                        if (AuthenticatorUtils.isDeviceCredentialAllowed(this.mAuthenticators)) {
                            i = R.string.face_or_screen_lock_prompt_message;
                        } else {
                            i = R.string.face_prompt_message;
                        }
                    } else if (AuthenticatorUtils.isDeviceCredentialAllowed(this.mAuthenticators)) {
                        i = R.string.biometric_or_screen_lock_prompt_message;
                    } else {
                        i = R.string.biometric_prompt_message;
                    }
                } else if (AuthenticatorUtils.isDeviceCredentialAllowed(this.mAuthenticators)) {
                    i = R.string.fingerprint_or_screen_lock_prompt_message;
                } else {
                    i = R.string.fingerprint_prompt_message;
                }
                return this.mResources.getString(i);
            } else if ((this.mPossibleModalities & 1) == 0) {
                return null;
            } else {
                return this.mResources.getString(R.string.screen_lock_prompt_message);
            }
        }

        CharSequence getSettingName() {
            int i = this.mPossibleModalities;
            if (i != 0) {
                if (i == 1) {
                    return this.mResources.getString(R.string.use_screen_lock_label);
                }
                if (i == 2) {
                    return this.mResources.getString(R.string.use_biometric_label);
                }
                if (i == 4) {
                    return this.mResources.getString(R.string.use_fingerprint_label);
                }
                if (i == 8) {
                    return this.mResources.getString(R.string.use_face_label);
                }
                if ((i & 1) == 0) {
                    return this.mResources.getString(R.string.use_biometric_label);
                }
                int i2 = i & (-2);
                if (i2 == 4) {
                    return this.mResources.getString(R.string.use_fingerprint_or_screen_lock_label);
                }
                if (i2 == 8) {
                    return this.mResources.getString(R.string.use_face_or_screen_lock_label);
                }
                return this.mResources.getString(R.string.use_biometric_or_screen_lock_label);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class DefaultInjector implements Injector {
        private final Context mContext;

        DefaultInjector(Context context) {
            this.mContext = context.getApplicationContext();
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public Resources getResources() {
            return this.mContext.getResources();
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public android.hardware.biometrics.BiometricManager getBiometricManager() {
            return Api29Impl.create(this.mContext);
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public FingerprintManagerCompat getFingerprintManager() {
            return FingerprintManagerCompat.from(this.mContext);
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public boolean isDeviceSecurable() {
            return KeyguardUtils.getKeyguardManager(this.mContext) != null;
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public boolean isDeviceSecuredWithCredential() {
            return KeyguardUtils.isDeviceSecuredWithCredential(this.mContext);
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public boolean isFingerprintHardwarePresent() {
            return PackageUtils.hasSystemFeatureFingerprint(this.mContext);
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public boolean isFaceHardwarePresent() {
            return PackageUtils.hasSystemFeatureFace(this.mContext);
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public boolean isIrisHardwarePresent() {
            return PackageUtils.hasSystemFeatureIris(this.mContext);
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public boolean isStrongBiometricGuaranteed() {
            return DeviceUtils.canAssumeStrongBiometrics(this.mContext, Build.MODEL);
        }
    }

    public static BiometricManager from(Context context) {
        return new BiometricManager(new DefaultInjector(context));
    }

    BiometricManager(Injector injector) {
        this.mInjector = injector;
        FingerprintManagerCompat fingerprintManagerCompat = null;
        this.mBiometricManager = Build.VERSION.SDK_INT >= 29 ? injector.getBiometricManager() : null;
        this.mFingerprintManager = Build.VERSION.SDK_INT <= 29 ? injector.getFingerprintManager() : fingerprintManagerCompat;
    }

    @Deprecated
    public int canAuthenticate() {
        return canAuthenticate(255);
    }

    public int canAuthenticate(int i) {
        if (Build.VERSION.SDK_INT >= 30) {
            android.hardware.biometrics.BiometricManager biometricManager = this.mBiometricManager;
            if (biometricManager == null) {
                Log.e(TAG, "Failure in canAuthenticate(). BiometricManager was null.");
                return 1;
            }
            return Api30Impl.canAuthenticate(biometricManager, i);
        }
        return canAuthenticateCompat(i);
    }

    private int canAuthenticateCompat(int i) {
        if (!AuthenticatorUtils.isSupportedCombination(i)) {
            return -2;
        }
        if (i == 0 || !this.mInjector.isDeviceSecurable()) {
            return 12;
        }
        if (AuthenticatorUtils.isDeviceCredentialAllowed(i)) {
            return this.mInjector.isDeviceSecuredWithCredential() ? 0 : 11;
        } else if (Build.VERSION.SDK_INT == 29) {
            if (AuthenticatorUtils.isWeakBiometricAllowed(i)) {
                return canAuthenticateWithWeakBiometricOnApi29();
            }
            return canAuthenticateWithStrongBiometricOnApi29();
        } else if (Build.VERSION.SDK_INT == 28) {
            if (!this.mInjector.isFingerprintHardwarePresent()) {
                return 12;
            }
            return canAuthenticateWithFingerprintOrUnknownBiometric();
        } else {
            return canAuthenticateWithFingerprint();
        }
    }

    private int canAuthenticateWithStrongBiometricOnApi29() {
        BiometricPrompt.CryptoObject wrapForBiometricPrompt;
        Method canAuthenticateWithCryptoMethod = Api29Impl.getCanAuthenticateWithCryptoMethod();
        if (canAuthenticateWithCryptoMethod != null && (wrapForBiometricPrompt = CryptoObjectUtils.wrapForBiometricPrompt(CryptoObjectUtils.createFakeCryptoObject())) != null) {
            try {
                Object invoke = Build.VERSION.SDK_INT == 29 ? canAuthenticateWithCryptoMethod.invoke(this.mBiometricManager, wrapForBiometricPrompt) : null;
                if (invoke instanceof Integer) {
                    return ((Integer) invoke).intValue();
                }
                Log.w(TAG, "Invalid return type for canAuthenticate(CryptoObject).");
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                Log.w(TAG, "Failed to invoke canAuthenticate(CryptoObject).", e);
            }
        }
        int canAuthenticateWithWeakBiometricOnApi29 = canAuthenticateWithWeakBiometricOnApi29();
        return (this.mInjector.isStrongBiometricGuaranteed() || canAuthenticateWithWeakBiometricOnApi29 != 0) ? canAuthenticateWithWeakBiometricOnApi29 : canAuthenticateWithFingerprintOrUnknownBiometric();
    }

    private int canAuthenticateWithWeakBiometricOnApi29() {
        android.hardware.biometrics.BiometricManager biometricManager = this.mBiometricManager;
        if (biometricManager == null) {
            Log.e(TAG, "Failure in canAuthenticate(). BiometricManager was null.");
            return 1;
        }
        return Api29Impl.canAuthenticate(biometricManager);
    }

    private int canAuthenticateWithFingerprintOrUnknownBiometric() {
        if (!this.mInjector.isDeviceSecuredWithCredential()) {
            return canAuthenticateWithFingerprint();
        }
        return canAuthenticateWithFingerprint() == 0 ? 0 : -1;
    }

    private int canAuthenticateWithFingerprint() {
        FingerprintManagerCompat fingerprintManagerCompat = this.mFingerprintManager;
        if (fingerprintManagerCompat == null) {
            Log.e(TAG, "Failure in canAuthenticate(). FingerprintManager was null.");
            return 1;
        } else if (!fingerprintManagerCompat.isHardwareDetected()) {
            return 12;
        } else {
            return !this.mFingerprintManager.hasEnrolledFingerprints() ? 11 : 0;
        }
    }

    public Strings getStrings(int i) {
        if (Build.VERSION.SDK_INT >= 31) {
            if (this.mBiometricManager == null) {
                Log.e(TAG, "Failure in getStrings(). BiometricManager was null.");
                return null;
            }
            return new Strings(Api31Impl.getStrings(this.mBiometricManager, i));
        }
        return new Strings(new StringsCompat(this.mInjector.getResources(), i, this.mInjector.isFingerprintHardwarePresent(), this.mInjector.isFaceHardwarePresent(), this.mInjector.isIrisHardwarePresent(), this.mInjector.isDeviceSecuredWithCredential()));
    }

    /* loaded from: classes.dex */
    private static class Api31Impl {
        private Api31Impl() {
        }

        static BiometricManager.Strings getStrings(android.hardware.biometrics.BiometricManager biometricManager, int i) {
            return biometricManager.getStrings(i);
        }

        static CharSequence getButtonLabel(BiometricManager.Strings strings) {
            return strings.getButtonLabel();
        }

        static CharSequence getPromptMessage(BiometricManager.Strings strings) {
            return strings.getPromptMessage();
        }

        static CharSequence getSettingName(BiometricManager.Strings strings) {
            return strings.getSettingName();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Api30Impl {
        private Api30Impl() {
        }

        static int canAuthenticate(android.hardware.biometrics.BiometricManager biometricManager, int i) {
            return biometricManager.canAuthenticate(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Api29Impl {
        private Api29Impl() {
        }

        static android.hardware.biometrics.BiometricManager create(Context context) {
            return (android.hardware.biometrics.BiometricManager) context.getSystemService(android.hardware.biometrics.BiometricManager.class);
        }

        static int canAuthenticate(android.hardware.biometrics.BiometricManager biometricManager) {
            return biometricManager.canAuthenticate();
        }

        static Method getCanAuthenticateWithCryptoMethod() {
            try {
                return android.hardware.biometrics.BiometricManager.class.getMethod("canAuthenticate", BiometricPrompt.CryptoObject.class);
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
    }
}