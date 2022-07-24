package androidx.biometric.auth;

import androidx.biometric.BiometricPrompt;
import androidx.biometric.auth.Class2BiometricOrCredentialAuthPrompt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: Class2BiometricOrCredentialAuthExtensions.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0002\u001aF\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u001d\u0010\u0010\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a?\u0010\u0013\u001a\u00020\u0011*\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a?\u0010\u0013\u001a\u00020\u0011*\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001aH\u0010\u0018\u001a\u00020\t*\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f\u001aH\u0010\u0018\u001a\u00020\t*\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"buildClass2BiometricOrCredentialAuthPrompt", "Landroidx/biometric/auth/Class2BiometricOrCredentialAuthPrompt;", "title", "", "subtitle", "description", "confirmationRequired", "", "startClass2BiometricOrCredentialAuthenticationInternal", "Landroidx/biometric/auth/AuthPrompt;", "host", "Landroidx/biometric/auth/AuthPromptHost;", "executor", "Ljava/util/concurrent/Executor;", "callback", "Landroidx/biometric/auth/AuthPromptCallback;", "authenticate", "Landroidx/biometric/BiometricPrompt$AuthenticationResult;", "(Landroidx/biometric/auth/Class2BiometricOrCredentialAuthPrompt;Landroidx/biometric/auth/AuthPromptHost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authenticateWithClass2BiometricsOrCredentials", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startClass2BiometricOrCredentialAuthentication", "biometric-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class Class2BiometricOrCredentialAuthExtensionsKt {
    public static final AuthPrompt startClass2BiometricOrCredentialAuthentication(FragmentActivity fragmentActivity, CharSequence title, CharSequence charSequence, CharSequence charSequence2, boolean z, Executor executor, AuthPromptCallback callback) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return startClass2BiometricOrCredentialAuthenticationInternal(new AuthPromptHost(fragmentActivity), title, charSequence, charSequence2, z, executor, callback);
    }

    public static /* synthetic */ Object authenticateWithClass2BiometricsOrCredentials$default(FragmentActivity fragmentActivity, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, boolean z, Continuation continuation, int i, Object obj) {
        CharSequence charSequence4 = (i & 2) != 0 ? null : charSequence2;
        CharSequence charSequence5 = (i & 4) != 0 ? null : charSequence3;
        if ((i & 8) != 0) {
            z = true;
        }
        return authenticateWithClass2BiometricsOrCredentials(fragmentActivity, charSequence, charSequence4, charSequence5, z, continuation);
    }

    public static final Object authenticateWithClass2BiometricsOrCredentials(FragmentActivity fragmentActivity, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, boolean z, Continuation<? super BiometricPrompt.AuthenticationResult> continuation) {
        return authenticate(buildClass2BiometricOrCredentialAuthPrompt(charSequence, charSequence2, charSequence3, z), new AuthPromptHost(fragmentActivity), continuation);
    }

    public static final AuthPrompt startClass2BiometricOrCredentialAuthentication(Fragment fragment, CharSequence title, CharSequence charSequence, CharSequence charSequence2, boolean z, Executor executor, AuthPromptCallback callback) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return startClass2BiometricOrCredentialAuthenticationInternal(new AuthPromptHost(fragment), title, charSequence, charSequence2, z, executor, callback);
    }

    public static /* synthetic */ Object authenticateWithClass2BiometricsOrCredentials$default(Fragment fragment, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, boolean z, Continuation continuation, int i, Object obj) {
        CharSequence charSequence4 = (i & 2) != 0 ? null : charSequence2;
        CharSequence charSequence5 = (i & 4) != 0 ? null : charSequence3;
        if ((i & 8) != 0) {
            z = true;
        }
        return authenticateWithClass2BiometricsOrCredentials(fragment, charSequence, charSequence4, charSequence5, z, continuation);
    }

    public static final Object authenticateWithClass2BiometricsOrCredentials(Fragment fragment, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, boolean z, Continuation<? super BiometricPrompt.AuthenticationResult> continuation) {
        return authenticate(buildClass2BiometricOrCredentialAuthPrompt(charSequence, charSequence2, charSequence3, z), new AuthPromptHost(fragment), continuation);
    }

    private static final AuthPrompt startClass2BiometricOrCredentialAuthenticationInternal(AuthPromptHost authPromptHost, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, boolean z, Executor executor, AuthPromptCallback authPromptCallback) {
        Class2BiometricOrCredentialAuthPrompt buildClass2BiometricOrCredentialAuthPrompt = buildClass2BiometricOrCredentialAuthPrompt(charSequence, charSequence2, charSequence3, z);
        if (executor == null) {
            AuthPrompt startAuthentication = buildClass2BiometricOrCredentialAuthPrompt.startAuthentication(authPromptHost, authPromptCallback);
            Intrinsics.checkNotNullExpressionValue(startAuthentication, "{\n        prompt.startAu…ion(host, callback)\n    }");
            return startAuthentication;
        }
        AuthPrompt startAuthentication2 = buildClass2BiometricOrCredentialAuthPrompt.startAuthentication(authPromptHost, executor, authPromptCallback);
        Intrinsics.checkNotNullExpressionValue(startAuthentication2, "{\n        prompt.startAu…executor, callback)\n    }");
        return startAuthentication2;
    }

    static /* synthetic */ Class2BiometricOrCredentialAuthPrompt buildClass2BiometricOrCredentialAuthPrompt$default(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            charSequence2 = null;
        }
        if ((i & 4) != 0) {
            charSequence3 = null;
        }
        if ((i & 8) != 0) {
            z = true;
        }
        return buildClass2BiometricOrCredentialAuthPrompt(charSequence, charSequence2, charSequence3, z);
    }

    private static final Class2BiometricOrCredentialAuthPrompt buildClass2BiometricOrCredentialAuthPrompt(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, boolean z) {
        Class2BiometricOrCredentialAuthPrompt.Builder builder = new Class2BiometricOrCredentialAuthPrompt.Builder(charSequence);
        if (charSequence2 != null) {
            builder.setSubtitle(charSequence2);
        }
        if (charSequence3 != null) {
            builder.setDescription(charSequence3);
        }
        builder.setConfirmationRequired(z);
        Class2BiometricOrCredentialAuthPrompt build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(title)\n    .appl…uired)\n    }\n    .build()");
        return build;
    }

    public static final Object authenticate(Class2BiometricOrCredentialAuthPrompt class2BiometricOrCredentialAuthPrompt, AuthPromptHost authPromptHost, Continuation<? super BiometricPrompt.AuthenticationResult> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        AuthPrompt startAuthentication = class2BiometricOrCredentialAuthPrompt.startAuthentication(authPromptHost, Class2BiometricAuthExtensionsKt$$ExternalSyntheticLambda0.INSTANCE, new CoroutineAuthPromptCallback(cancellableContinuationImpl2));
        Intrinsics.checkNotNullExpressionValue(startAuthentication, "startAuthentication(\n   …k(continuation)\n        )");
        cancellableContinuationImpl2.invokeOnCancellation(new Class2BiometricOrCredentialAuthExtensionsKt$authenticate$2$1(startAuthentication));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}