package androidx.biometric.auth;

import androidx.biometric.BiometricPrompt;
import androidx.biometric.auth.Class2BiometricAuthPrompt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: Class2BiometricAuthExtensions.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a4\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001aN\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u001d\u0010\u0011\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aG\u0010\u0014\u001a\u00020\u0012*\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001aG\u0010\u0014\u001a\u00020\u0012*\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aP\u0010\u0019\u001a\u00020\n*\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010\u001aP\u0010\u0019\u001a\u00020\n*\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"buildClass2BiometricAuthPrompt", "Landroidx/biometric/auth/Class2BiometricAuthPrompt;", "title", "", "negativeButtonText", "subtitle", "description", "confirmationRequired", "", "startClass2BiometricAuthenticationInternal", "Landroidx/biometric/auth/AuthPrompt;", "host", "Landroidx/biometric/auth/AuthPromptHost;", "executor", "Ljava/util/concurrent/Executor;", "callback", "Landroidx/biometric/auth/AuthPromptCallback;", "authenticate", "Landroidx/biometric/BiometricPrompt$AuthenticationResult;", "(Landroidx/biometric/auth/Class2BiometricAuthPrompt;Landroidx/biometric/auth/AuthPromptHost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authenticateWithClass2Biometrics", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startClass2BiometricAuthentication", "biometric-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class Class2BiometricAuthExtensionsKt {
    public static final AuthPrompt startClass2BiometricAuthentication(FragmentActivity fragmentActivity, CharSequence title, CharSequence negativeButtonText, CharSequence charSequence, CharSequence charSequence2, boolean z, Executor executor, AuthPromptCallback callback) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(negativeButtonText, "negativeButtonText");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return startClass2BiometricAuthenticationInternal(new AuthPromptHost(fragmentActivity), title, negativeButtonText, charSequence, charSequence2, z, executor, callback);
    }

    public static final Object authenticateWithClass2Biometrics(FragmentActivity fragmentActivity, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, boolean z, Continuation<? super BiometricPrompt.AuthenticationResult> continuation) {
        return authenticate(buildClass2BiometricAuthPrompt(charSequence, charSequence2, charSequence3, charSequence4, z), new AuthPromptHost(fragmentActivity), continuation);
    }

    public static final AuthPrompt startClass2BiometricAuthentication(Fragment fragment, CharSequence title, CharSequence negativeButtonText, CharSequence charSequence, CharSequence charSequence2, boolean z, Executor executor, AuthPromptCallback callback) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(negativeButtonText, "negativeButtonText");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return startClass2BiometricAuthenticationInternal(new AuthPromptHost(fragment), title, negativeButtonText, charSequence, charSequence2, z, executor, callback);
    }

    public static final Object authenticateWithClass2Biometrics(Fragment fragment, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, boolean z, Continuation<? super BiometricPrompt.AuthenticationResult> continuation) {
        return authenticate(buildClass2BiometricAuthPrompt(charSequence, charSequence2, charSequence3, charSequence4, z), new AuthPromptHost(fragment), continuation);
    }

    private static final AuthPrompt startClass2BiometricAuthenticationInternal(AuthPromptHost authPromptHost, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, boolean z, Executor executor, AuthPromptCallback authPromptCallback) {
        Class2BiometricAuthPrompt buildClass2BiometricAuthPrompt = buildClass2BiometricAuthPrompt(charSequence, charSequence2, charSequence3, charSequence4, z);
        if (executor == null) {
            AuthPrompt startAuthentication = buildClass2BiometricAuthPrompt.startAuthentication(authPromptHost, authPromptCallback);
            Intrinsics.checkNotNullExpressionValue(startAuthentication, "{\n        prompt.startAu…ion(host, callback)\n    }");
            return startAuthentication;
        }
        AuthPrompt startAuthentication2 = buildClass2BiometricAuthPrompt.startAuthentication(authPromptHost, executor, authPromptCallback);
        Intrinsics.checkNotNullExpressionValue(startAuthentication2, "{\n        prompt.startAu…executor, callback)\n    }");
        return startAuthentication2;
    }

    private static final Class2BiometricAuthPrompt buildClass2BiometricAuthPrompt(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, boolean z) {
        Class2BiometricAuthPrompt.Builder builder = new Class2BiometricAuthPrompt.Builder(charSequence, charSequence2);
        if (charSequence3 != null) {
            builder.setSubtitle(charSequence3);
        }
        if (charSequence4 != null) {
            builder.setDescription(charSequence4);
        }
        builder.setConfirmationRequired(z);
        Class2BiometricAuthPrompt build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(title, negativeB…uired)\n    }\n    .build()");
        return build;
    }

    public static final Object authenticate(Class2BiometricAuthPrompt class2BiometricAuthPrompt, AuthPromptHost authPromptHost, Continuation<? super BiometricPrompt.AuthenticationResult> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        AuthPrompt startAuthentication = class2BiometricAuthPrompt.startAuthentication(authPromptHost, Class2BiometricAuthExtensionsKt$$ExternalSyntheticLambda0.INSTANCE, new CoroutineAuthPromptCallback(cancellableContinuationImpl2));
        Intrinsics.checkNotNullExpressionValue(startAuthentication, "startAuthentication(\n   …k(continuation)\n        )");
        cancellableContinuationImpl2.invokeOnCancellation(new Class2BiometricAuthExtensionsKt$authenticate$2$1(startAuthentication));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}