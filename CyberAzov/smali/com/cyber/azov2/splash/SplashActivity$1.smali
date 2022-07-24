.class Lcom/cyber/azov2/splash/SplashActivity$1;
.super Landroid/animation/AnimatorListenerAdapter;
.source "SplashActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/cyber/azov2/splash/SplashActivity;->setupAnimation()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/cyber/azov2/splash/SplashActivity;


# direct methods
.method constructor <init>(Lcom/cyber/azov2/splash/SplashActivity;)V
    .locals 0

    .line 31
    iput-object p1, p0, Lcom/cyber/azov2/splash/SplashActivity$1;->this$0:Lcom/cyber/azov2/splash/SplashActivity;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 0

    .line 34
    iget-object p1, p0, Lcom/cyber/azov2/splash/SplashActivity$1;->this$0:Lcom/cyber/azov2/splash/SplashActivity;

    invoke-static {p1}, Lcom/cyber/azov2/splash/SplashActivity;->-$$Nest$mstartMainActivity(Lcom/cyber/azov2/splash/SplashActivity;)V

    return-void
.end method
