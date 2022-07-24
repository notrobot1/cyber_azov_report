package androidx.biometric.auth;

import androidx.biometric.BiometricPrompt;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class Class2BiometricOrCredentialAuthPrompt {
    private final BiometricPrompt.PromptInfo mPromptInfo;

    Class2BiometricOrCredentialAuthPrompt(BiometricPrompt.PromptInfo promptInfo) {
        this.mPromptInfo = promptInfo;
    }

    public AuthPrompt startAuthentication(AuthPromptHost authPromptHost, AuthPromptCallback authPromptCallback) {
        return AuthPromptUtils.startAuthentication(authPromptHost, this.mPromptInfo, null, null, authPromptCallback);
    }

    public AuthPrompt startAuthentication(AuthPromptHost authPromptHost, Executor executor, AuthPromptCallback authPromptCallback) {
        return AuthPromptUtils.startAuthentication(authPromptHost, this.mPromptInfo, null, executor, authPromptCallback);
    }

    public CharSequence getTitle() {
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
        private final CharSequence mTitle;
        private CharSequence mSubtitle = null;
        private CharSequence mDescription = null;
        private boolean mIsConfirmationRequired = true;

        public Builder(CharSequence charSequence) {
            this.mTitle = charSequence;
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

        public Class2BiometricOrCredentialAuthPrompt build() {
            return new Class2BiometricOrCredentialAuthPrompt(new BiometricPrompt.PromptInfo.Builder().setTitle(this.mTitle).setSubtitle(this.mSubtitle).setDescription(this.mDescription).setConfirmationRequired(this.mIsConfirmationRequired).setAllowedAuthenticators(33023).build());
        }
    }
}