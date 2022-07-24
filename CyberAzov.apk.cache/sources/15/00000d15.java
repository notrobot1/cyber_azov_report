package androidx.biometric.auth;

import androidx.biometric.BiometricPrompt;
import androidx.biometric.auth.CredentialAuthPrompt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: CredentialAuthExtensions.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0003\u001a>\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0003\u001a'\u0010\u000f\u001a\u00020\u0010*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a3\u0010\u0012\u001a\u00020\u0010*\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a3\u0010\u0012\u001a\u00020\u0010*\u00020\u00152\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a>\u0010\u0017\u001a\u00020\u0006*\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001a>\u0010\u0017\u001a\u00020\u0006*\u00020\u00152\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"buildCredentialAuthPrompt", "Landroidx/biometric/auth/CredentialAuthPrompt;", "title", "", "description", "startCredentialAuthenticationInternal", "Landroidx/biometric/auth/AuthPrompt;", "host", "Landroidx/biometric/auth/AuthPromptHost;", "crypto", "Landroidx/biometric/BiometricPrompt$CryptoObject;", "executor", "Ljava/util/concurrent/Executor;", "callback", "Landroidx/biometric/auth/AuthPromptCallback;", "authenticate", "Landroidx/biometric/BiometricPrompt$AuthenticationResult;", "(Landroidx/biometric/auth/CredentialAuthPrompt;Landroidx/biometric/auth/AuthPromptHost;Landroidx/biometric/BiometricPrompt$CryptoObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authenticateWithCredentials", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Landroidx/biometric/BiometricPrompt$CryptoObject;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;Landroidx/biometric/BiometricPrompt$CryptoObject;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startCredentialAuthentication", "biometric-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class CredentialAuthExtensionsKt {
    public static final AuthPrompt startCredentialAuthentication(FragmentActivity fragmentActivity, BiometricPrompt.CryptoObject cryptoObject, CharSequence title, CharSequence charSequence, Executor executor, AuthPromptCallback callback) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return startCredentialAuthenticationInternal(new AuthPromptHost(fragmentActivity), cryptoObject, title, charSequence, executor, callback);
    }

    public static /* synthetic */ Object authenticateWithCredentials$default(FragmentActivity fragmentActivity, BiometricPrompt.CryptoObject cryptoObject, CharSequence charSequence, CharSequence charSequence2, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            charSequence2 = null;
        }
        return authenticateWithCredentials(fragmentActivity, cryptoObject, charSequence, charSequence2, continuation);
    }

    public static final Object authenticateWithCredentials(FragmentActivity fragmentActivity, BiometricPrompt.CryptoObject cryptoObject, CharSequence charSequence, CharSequence charSequence2, Continuation<? super BiometricPrompt.AuthenticationResult> continuation) {
        return authenticate(buildCredentialAuthPrompt(charSequence, charSequence2), new AuthPromptHost(fragmentActivity), cryptoObject, continuation);
    }

    public static final AuthPrompt startCredentialAuthentication(Fragment fragment, BiometricPrompt.CryptoObject cryptoObject, CharSequence title, CharSequence charSequence, Executor executor, AuthPromptCallback callback) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return startCredentialAuthenticationInternal(new AuthPromptHost(fragment), cryptoObject, title, charSequence, executor, callback);
    }

    public static /* synthetic */ Object authenticateWithCredentials$default(Fragment fragment, BiometricPrompt.CryptoObject cryptoObject, CharSequence charSequence, CharSequence charSequence2, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            charSequence2 = null;
        }
        return authenticateWithCredentials(fragment, cryptoObject, charSequence, charSequence2, continuation);
    }

    public static final Object authenticateWithCredentials(Fragment fragment, BiometricPrompt.CryptoObject cryptoObject, CharSequence charSequence, CharSequence charSequence2, Continuation<? super BiometricPrompt.AuthenticationResult> continuation) {
        return authenticate(buildCredentialAuthPrompt(charSequence, charSequence2), new AuthPromptHost(fragment), cryptoObject, continuation);
    }

    private static final AuthPrompt startCredentialAuthenticationInternal(AuthPromptHost authPromptHost, BiometricPrompt.CryptoObject cryptoObject, CharSequence charSequence, CharSequence charSequence2, Executor executor, AuthPromptCallback authPromptCallback) {
        CredentialAuthPrompt buildCredentialAuthPrompt = buildCredentialAuthPrompt(charSequence, charSequence2);
        if (executor == null) {
            AuthPrompt startAuthentication = buildCredentialAuthPrompt.startAuthentication(authPromptHost, cryptoObject, authPromptCallback);
            Intrinsics.checkNotNullExpressionValue(startAuthentication, "{\n        prompt.startAu…, crypto, callback)\n    }");
            return startAuthentication;
        }
        AuthPrompt startAuthentication2 = buildCredentialAuthPrompt.startAuthentication(authPromptHost, cryptoObject, executor, authPromptCallback);
        Intrinsics.checkNotNullExpressionValue(startAuthentication2, "{\n        prompt.startAu…executor, callback)\n    }");
        return startAuthentication2;
    }

    private static final CredentialAuthPrompt buildCredentialAuthPrompt(CharSequence charSequence, CharSequence charSequence2) {
        CredentialAuthPrompt.Builder builder = new CredentialAuthPrompt.Builder(charSequence);
        if (charSequence2 != null) {
            builder.setDescription(charSequence2);
        }
        CredentialAuthPrompt buildCredentialAuthPrompt = builder.build();
        Intrinsics.checkNotNullExpressionValue(buildCredentialAuthPrompt, "buildCredentialAuthPrompt");
        return buildCredentialAuthPrompt;
    }

    public static final Object authenticate(CredentialAuthPrompt credentialAuthPrompt, AuthPromptHost authPromptHost, BiometricPrompt.CryptoObject cryptoObject, Continuation<? super BiometricPrompt.AuthenticationResult> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        AuthPrompt startAuthentication = credentialAuthPrompt.startAuthentication(authPromptHost, cryptoObject, Class2BiometricAuthExtensionsKt$$ExternalSyntheticLambda0.INSTANCE, new CoroutineAuthPromptCallback(cancellableContinuationImpl2));
        Intrinsics.checkNotNullExpressionValue(startAuthentication, "startAuthentication(\n   …k(continuation)\n        )");
        cancellableContinuationImpl2.invokeOnCancellation(new CredentialAuthExtensionsKt$authenticate$2$1(startAuthentication));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}