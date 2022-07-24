.class public Lcom/cyber/azov2/splash/SplashActivity;
.super Landroidx/appcompat/app/AppCompatActivity;
.source "SplashActivity.java"


# instance fields
.field private binding:Lcom/example/guiproposal/databinding/ActivitySplashBinding;

.field private final shortAnimationDuration:J


# direct methods
.method static bridge synthetic -$$Nest$mstartMainActivity(Lcom/cyber/azov2/splash/SplashActivity;)V
    .locals 0

    invoke-direct {p0}, Lcom/cyber/azov2/splash/SplashActivity;->startMainActivity()V

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .line 17
    invoke-direct {p0}, Landroidx/appcompat/app/AppCompatActivity;-><init>()V

    const-wide/16 v0, 0x7d0

    .line 19
    iput-wide v0, p0, Lcom/cyber/azov2/splash/SplashActivity;->shortAnimationDuration:J

    return-void
.end method

.method private setupAlphaAnimation(Landroid/view/View;Landroid/animation/Animator$AnimatorListener;)V
    .locals 2

    const/16 v0, 0x8

    .line 44
    invoke-virtual {p1, v0}, Landroid/view/View;->setVisibility(I)V

    const/4 v0, 0x0

    .line 45
    invoke-virtual {p1, v0}, Landroid/view/View;->setAlpha(F)V

    const/4 v0, 0x0

    .line 46
    invoke-virtual {p1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 47
    invoke-virtual {p1}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object p1

    const/high16 v0, 0x3f800000    # 1.0f

    .line 48
    invoke-virtual {p1, v0}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object p1

    const-wide/16 v0, 0x7d0

    .line 49
    invoke-virtual {p1, v0, v1}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object p1

    .line 50
    invoke-virtual {p1, p2}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    return-void
.end method

.method private setupAnimation()V
    .locals 2

    .line 31
    iget-object v0, p0, Lcom/cyber/azov2/splash/SplashActivity;->binding:Lcom/example/guiproposal/databinding/ActivitySplashBinding;

    iget-object v0, v0, Lcom/example/guiproposal/databinding/ActivitySplashBinding;->splashLogo:Landroid/widget/ImageView;

    new-instance v1, Lcom/cyber/azov2/splash/SplashActivity$1;

    invoke-direct {v1, p0}, Lcom/cyber/azov2/splash/SplashActivity$1;-><init>(Lcom/cyber/azov2/splash/SplashActivity;)V

    invoke-direct {p0, v0, v1}, Lcom/cyber/azov2/splash/SplashActivity;->setupAlphaAnimation(Landroid/view/View;Landroid/animation/Animator$AnimatorListener;)V

    .line 37
    iget-object v0, p0, Lcom/cyber/azov2/splash/SplashActivity;->binding:Lcom/example/guiproposal/databinding/ActivitySplashBinding;

    iget-object v0, v0, Lcom/example/guiproposal/databinding/ActivitySplashBinding;->splashMotto:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/cyber/azov2/splash/SplashActivity;->setupAlphaAnimation(Landroid/view/View;Landroid/animation/Animator$AnimatorListener;)V

    return-void
.end method

.method private startMainActivity()V
    .locals 2

    .line 54
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/cyber/azov2/MainActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const v1, 0x10008000

    .line 55
    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 56
    invoke-virtual {p0, v0}, Lcom/cyber/azov2/splash/SplashActivity;->startActivity(Landroid/content/Intent;)V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1

    .line 23
    invoke-super {p0, p1}, Landroidx/appcompat/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    const/high16 p1, 0x10a0000

    const v0, 0x10a0001

    .line 24
    invoke-virtual {p0, p1, v0}, Lcom/cyber/azov2/splash/SplashActivity;->overridePendingTransition(II)V

    .line 25
    invoke-virtual {p0}, Lcom/cyber/azov2/splash/SplashActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object p1

    invoke-static {p1}, Lcom/example/guiproposal/databinding/ActivitySplashBinding;->inflate(Landroid/view/LayoutInflater;)Lcom/example/guiproposal/databinding/ActivitySplashBinding;

    move-result-object p1

    iput-object p1, p0, Lcom/cyber/azov2/splash/SplashActivity;->binding:Lcom/example/guiproposal/databinding/ActivitySplashBinding;

    .line 26
    invoke-virtual {p1}, Lcom/example/guiproposal/databinding/ActivitySplashBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/cyber/azov2/splash/SplashActivity;->setContentView(Landroid/view/View;)V

    .line 27
    invoke-direct {p0}, Lcom/cyber/azov2/splash/SplashActivity;->setupAnimation()V

    return-void
.end method
