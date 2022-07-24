package androidx.biometric.auth;

import androidx.biometric.BiometricPrompt;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class Class3BiometricAuthPrompt {
    private final BiometricPrompt.PromptInfo mPromptInfo;

    Class3BiometricAuthPrompt(BiometricPrompt.PromptInfo promptInfo) {
        this.mPromptInfo = promptInfo;
    }

    public AuthPrompt startAuthentication(AuthPromptHost authPromptHost, BiometricPrompt.CryptoObject cryptoObject, AuthPromptCallback authPromptCallback) {
        return AuthPromptUtils.startAuthentication(authPromptHost, this.mPromptInfo, cryptoObject, null, authPromptCallback);
    }

    public AuthPrompt startAuthentication(AuthPromptHost authPromptHost, BiometricPrompt.CryptoObject cryptoObject, Executor executor, AuthPromptCallback authPromptCallback) {
        return AuthPromptUtils.startAuthentication(authPromptHost, this.mPromptInfo, cryptoObject, executor, authPromptCallback);
    }

    public CharSequence getTitle() {
        return this.mPromptInfo.getTitle();
    }

    public CharSequence getNegativeButtonText() {
        return this.mPromptInfo.getTitle();
    }

    public CharSequence getSubtitle() {
        return this.mPromptInfo.getSubtitle();
    }

    public CharSequence getDescription() {
        return this.mPromptInfo.getDescription();
    }

    public boolean isConfirmationRequired() {
        return this.mPromptInfo.isConfirmationRequired();
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private final CharSequence mNegativeButtonText;
        private final CharSequence mTitle;
        private CharSequence mSubtitle = null;
        private CharSequence mDescription = null;
        private boolean mIsConfirmationRequired = true;

        public Builder(CharSequence charSequence, CharSequence charSequence2) {
            this.mTitle = charSequence;
            this.mNegativeButtonText = charSequence2;
        }

        public Builder setSubtitle(CharSequence charSequence) {
            this.mSubtitle = charSequence;
            return this;
        }

        public Builder setDescription(CharSequence charSequence) {
            this.mDescription = charSequence;
            return this;
        }

        public Builder setConfirmationRequired(boolean z) {
            this.mIsConfirmationRequired = z;
            return this;
        }

        public Class3BiometricAuthPrompt build() {
            return new Class3BiometricAuthPrompt(new BiometricPrompt.PromptInfo.Builder().setTitle(this.mTitle).setSubtitle(this.mSubtitle).setDescription(this.mDescription).setNegativeButtonText(this.mNegativeButtonText).setConfirmationRequired(this.mIsConfirmationRequired).setAllowedAuthenticators(15).build());
        }
    }
}