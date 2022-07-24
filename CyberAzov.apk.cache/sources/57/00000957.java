package androidx.biometric.auth;

import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.FragmentActivity;

/* loaded from: classes.dex */
public abstract class AuthPromptCallback {
    public void onAuthenticationError(FragmentActivity fragmentActivity, int i, CharSequence charSequence) {
    }

    public void onAuthenticationFailed(FragmentActivity fragmentActivity) {
    }

    public void onAuthenticationSucceeded(FragmentActivity fragmentActivity, BiometricPrompt.AuthenticationResult authenticationResult) {
    }
}