package androidx.biometric.auth;

import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: CoroutineAuthPromptCallback.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/biometric/auth/CoroutineAuthPromptCallback;", "Landroidx/biometric/auth/AuthPromptCallback;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Landroidx/biometric/BiometricPrompt$AuthenticationResult;", "(Lkotlinx/coroutines/CancellableContinuation;)V", "onAuthenticationError", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "errorCode", "", "errString", "", "onAuthenticationFailed", "onAuthenticationSucceeded", "result", "biometric-ktx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class CoroutineAuthPromptCallback extends AuthPromptCallback {
    private final CancellableContinuation<BiometricPrompt.AuthenticationResult> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public CoroutineAuthPromptCallback(CancellableContinuation<? super BiometricPrompt.AuthenticationResult> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        this.continuation = continuation;
    }

    @Override // androidx.biometric.auth.AuthPromptCallback
    public void onAuthenticationError(FragmentActivity fragmentActivity, int i, CharSequence errString) {
        Intrinsics.checkNotNullParameter(errString, "errString");
        Result.Companion companion = Result.Companion;
        this.continuation.resumeWith(Result.m48constructorimpl(ResultKt.createFailure(new AuthPromptErrorException(i, errString))));
    }

    @Override // androidx.biometric.auth.AuthPromptCallback
    public void onAuthenticationSucceeded(FragmentActivity fragmentActivity, BiometricPrompt.AuthenticationResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        CancellableContinuation<BiometricPrompt.AuthenticationResult> cancellableContinuation = this.continuation;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m48constructorimpl(result));
    }

    @Override // androidx.biometric.auth.AuthPromptCallback
    public void onAuthenticationFailed(FragmentActivity fragmentActivity) {
        Result.Companion companion = Result.Companion;
        this.continuation.resumeWith(Result.m48constructorimpl(ResultKt.createFailure(new AuthPromptFailureException())));
    }
}