package androidx.biometric.auth;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: CredentialAuthExtensions.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
final class CredentialAuthExtensionsKt$authenticate$2$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ AuthPrompt $authPrompt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CredentialAuthExtensionsKt$authenticate$2$1(AuthPrompt authPrompt) {
        super(1);
        this.$authPrompt = authPrompt;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.$authPrompt.cancelAuthentication();
    }
}