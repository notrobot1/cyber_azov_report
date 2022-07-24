package androidx.biometric.auth;

import androidx.biometric.BiometricPrompt;
import androidx.biometric.auth.Class3BiometricOrCredentialAuthPrompt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: Class3BiometricOrCredentialAuthExtensions.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0003\u001aP\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003\u001a'\u0010\u0012\u001a\u00020\u0013*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001aI\u0010\u0015\u001a\u00020\u0013*\u00020\u00162\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001aI\u0010\u0015\u001a\u00020\u0013*\u00020\u00182\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001aT\u0010\u001a\u001a\u00020\t*\u00020\u00162\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001aT\u0010\u001a\u001a\u00020\t*\u00020\u00182\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"buildClass3BiometricOrCredentialAuthPrompt", "Landroidx/biometric/auth/Class3BiometricOrCredentialAuthPrompt;", "title", "", "subtitle", "description", "confirmationRequired", "", "startClass3BiometricOrCredentialAuthenticationInternal", "Landroidx/biometric/auth/AuthPrompt;", "host", "Landroidx/biometric/auth/AuthPromptHost;", "crypto", "Landroidx/biometric/BiometricPrompt$CryptoObject;", "executor", "Ljava/util/concurrent/Executor;", "callback", "Landroidx/biometric/auth/AuthPromptCallback;", "authenticate", "Landroidx/biometric/BiometricPrompt$AuthenticationResult;", "(Landroidx/biometric/auth/Class3BiometricOrCredentialAuthPrompt;Landroidx/biometric/auth/AuthPromptHost;Landroidx/biometric/BiometricPrompt$CryptoObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authenticateWithClass3BiometricsOrCredentials", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Landroidx/biometric/BiometricPrompt$CryptoObject;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;Landroidx/biometric/BiometricPrompt$CryptoObject;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startClass3BiometricOrCredentialAuthentication", "biometric-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class Class3BiometricOrCredentialAuthExtensionsKt {
    public static final AuthPrompt startClass3BiometricOrCredentialAuthentication(FragmentActivity fragmentActivity, BiometricPrompt.CryptoObject cryptoObject, CharSequence title, CharSequence charSequence, CharSequence charSequence2, boolean z, Executor executor, AuthPromptCallback callback) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return startClass3BiometricOrCredentialAuthenticationInternal(new AuthPromptHost(fragmentActivity), cryptoObject, title, charSequence, charSequence2, z, executor, callback);
    }

    public static final Object authenticateWithClass3BiometricsOrCredentials(FragmentActivity fragmentActivity, BiometricPrompt.CryptoObject cryptoObject, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, boolean z, Continuation<? super BiometricPrompt.AuthenticationResult> continuation) {
        return authenticate(buildClass3BiometricOrCredentialAuthPrompt(charSequence, charSequence2, charSequence3, z), new AuthPromptHost(fragmentActivity), cryptoObject, continuation);
    }

    public static final AuthPrompt startClass3BiometricOrCredentialAuthentication(Fragment fragment, BiometricPrompt.CryptoObject cryptoObject, CharSequence title, CharSequence charSequence, CharSequence charSequence2, boolean z, Executor executor, AuthPromptCallback callback) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return startClass3BiometricOrCredentialAuthenticationInternal(new AuthPromptHost(fragment), cryptoObject, title, charSequence, charSequence2, z, executor, callback);
    }

    public static final Object authenticateWithClass3BiometricsOrCredentials(Fragment fragment, BiometricPrompt.CryptoObject cryptoObject, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, boolean z, Continuation<? super BiometricPrompt.AuthenticationResult> continuation) {
        return authenticate(buildClass3BiometricOrCredentialAuthPrompt(charSequence, charSequence2, charSequence3, z), new AuthPromptHost(fragment), cryptoObject, continuation);
    }

    private static final AuthPrompt startClass3BiometricOrCredentialAuthenticationInternal(AuthPromptHost authPromptHost, BiometricPrompt.CryptoObject cryptoObject, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, boolean z, Executor executor, AuthPromptCallback authPromptCallback) {
        Class3BiometricOrCredentialAuthPrompt buildClass3BiometricOrCredentialAuthPrompt = buildClass3BiometricOrCredentialAuthPrompt(charSequence, charSequence2, charSequence3, z);
        if (executor == null) {
            AuthPrompt startAuthentication = buildClass3BiometricOrCredentialAuthPrompt.startAuthentication(authPromptHost, cryptoObject, authPromptCallback);
            Intrinsics.checkNotNullExpressionValue(startAuthentication, "{\n        prompt.startAu…, crypto, callback)\n    }");
            return startAuthentication;
        }
        AuthPrompt startAuthentication2 = buildClass3BiometricOrCredentialAuthPrompt.startAuthentication(authPromptHost, cryptoObject, executor, authPromptCallback);
        Intrinsics.checkNotNullExpressionValue(startAuthentication2, "{\n        prompt.startAu…executor, callback)\n    }");
        return startAuthentication2;
    }

    private static final Class3BiometricOrCredentialAuthPrompt buildClass3BiometricOrCredentialAuthPrompt(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, boolean z) {
        Class3BiometricOrCredentialAuthPrompt.Builder builder = new Class3BiometricOrCredentialAuthPrompt.Builder(charSequence);
        if (charSequence2 != null) {
            builder.setSubtitle(charSequence2);
        }
        if (charSequence3 != null) {
            builder.setDescription(charSequence3);
        }
        builder.setConfirmationRequired(z);
        Class3BiometricOrCredentialAuthPrompt build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(title)\n    .appl…uired)\n    }\n    .build()");
        return build;
    }

    public static final Object authenticate(Class3BiometricOrCredentialAuthPrompt class3BiometricOrCredentialAuthPrompt, AuthPromptHost authPromptHost, BiometricPrompt.CryptoObject cryptoObject, Continuation<? super BiometricPrompt.AuthenticationResult> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        AuthPrompt startAuthentication = class3BiometricOrCredentialAuthPrompt.startAuthentication(authPromptHost, cryptoObject, Class2BiometricAuthExtensionsKt$$ExternalSyntheticLambda0.INSTANCE, new CoroutineAuthPromptCallback(cancellableContinuationImpl2));
        Intrinsics.checkNotNullExpressionValue(startAuthentication, "startAuthentication(\n   …k(continuation)\n        )");
        cancellableContinuationImpl2.invokeOnCancellation(new Class3BiometricOrCredentialAuthExtensionsKt$authenticate$2$1(startAuthentication));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}