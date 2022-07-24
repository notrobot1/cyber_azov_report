package androidx.biometric.auth;

import androidx.biometric.BiometricPrompt;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class CredentialAuthPrompt {
    private final BiometricPrompt.PromptInfo mPromptInfo;

    CredentialAuthPrompt(BiometricPrompt.PromptInfo promptInfo) {
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

    public CharSequence getDescription() {
        return this.mPromptInfo.getDescription();
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private CharSequence mDescription = null;
        private final CharSequence mTitle;

        public Builder(CharSequence charSequence) {
            this.mTitle = charSequence;
        }

        public Builder setDescription(CharSequence charSequence) {
            this.mDescription = charSequence;
            return this;
        }

        public CredentialAuthPrompt build() {
            return new CredentialAuthPrompt(new BiometricPrompt.PromptInfo.Builder().setTitle(this.mTitle).setDescription(this.mDescription).setAllowedAuthenticators(32768).build());
        }
    }
}