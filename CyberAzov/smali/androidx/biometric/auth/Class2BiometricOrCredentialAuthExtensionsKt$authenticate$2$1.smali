.class final Landroidx/biometric/auth/Class2BiometricOrCredentialAuthExtensionsKt$authenticate$2$1;
.super Lkotlin/jvm/internal/Lambda;
.source "Class2BiometricOrCredentialAuthExtensions.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function1;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroidx/biometric/auth/Class2BiometricOrCredentialAuthExtensionsKt;->authenticate(Landroidx/biometric/auth/Class2BiometricOrCredentialAuthPrompt;Landroidx/biometric/auth/AuthPromptHost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function1<",
        "Ljava/lang/Throwable;",
        "Lkotlin/Unit;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"
    }
    d2 = {
        "<anonymous>",
        "",
        "it",
        ""
    }
    k = 0x3
    mv = {
        0x1,
        0x5,
        0x1
    }
    xi = 0x30
.end annotation


# instance fields
.field final synthetic $authPrompt:Landroidx/biometric/auth/AuthPrompt;


# direct methods
.method constructor <init>(Landroidx/biometric/auth/AuthPrompt;)V
    .locals 0

    iput-object p1, p0, Landroidx/biometric/auth/Class2BiometricOrCredentialAuthExtensionsKt$authenticate$2$1;->$authPrompt:Landroidx/biometric/auth/AuthPrompt;

    const/4 p1, 0x1

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 52
    check-cast p1, Ljava/lang/Throwable;

    invoke-virtual {p0, p1}, Landroidx/biometric/auth/Class2BiometricOrCredentialAuthExtensionsKt$authenticate$2$1;->invoke(Ljava/lang/Throwable;)V

    sget-object p1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p1
.end method

.method public final invoke(Ljava/lang/Throwable;)V
    .locals 0

    .line 53
    iget-object p1, p0, Landroidx/biometric/auth/Class2BiometricOrCredentialAuthExtensionsKt$authenticate$2$1;->$authPrompt:Landroidx/biometric/auth/AuthPrompt;

    invoke-interface {p1}, Landroidx/biometric/auth/AuthPrompt;->cancelAuthentication()V

    return-void
.end method
