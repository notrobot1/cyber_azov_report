.class Landroidx/biometric/BiometricFragment$3;
.super Ljava/lang/Object;
.source "BiometricFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroidx/biometric/BiometricFragment;->sendFailureToClient()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroidx/biometric/BiometricFragment;

.field final synthetic val$viewModel:Landroidx/biometric/BiometricViewModel;


# direct methods
.method constructor <init>(Landroidx/biometric/BiometricFragment;Landroidx/biometric/BiometricViewModel;)V
    .locals 0

    .line 1125
    iput-object p1, p0, Landroidx/biometric/BiometricFragment$3;->this$0:Landroidx/biometric/BiometricFragment;

    iput-object p2, p0, Landroidx/biometric/BiometricFragment$3;->val$viewModel:Landroidx/biometric/BiometricViewModel;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .line 1128
    iget-object v0, p0, Landroidx/biometric/BiometricFragment$3;->val$viewModel:Landroidx/biometric/BiometricViewModel;

    invoke-virtual {v0}, Landroidx/biometric/BiometricViewModel;->getClientCallback()Landroidx/biometric/BiometricPrompt$AuthenticationCallback;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/biometric/BiometricPrompt$AuthenticationCallback;->onAuthenticationFailed()V

    return-void
.end method
