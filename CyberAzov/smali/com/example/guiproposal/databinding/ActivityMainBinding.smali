.class public final Lcom/example/guiproposal/databinding/ActivityMainBinding;
.super Ljava/lang/Object;
.source "ActivityMainBinding.java"

# interfaces
.implements Landroidx/viewbinding/ViewBinding;


# instance fields
.field public final included:Lcom/example/guiproposal/databinding/BottomSheetBinding;

.field public final levelLabel:Landroid/widget/TextView;

.field public final progressTv:Landroid/widget/TextView;

.field public final progressbar:Lcom/cyber/azov2/DeterminantCircularProgressBar;

.field private final rootView:Landroidx/constraintlayout/widget/ConstraintLayout;


# direct methods
.method private constructor <init>(Landroidx/constraintlayout/widget/ConstraintLayout;Lcom/example/guiproposal/databinding/BottomSheetBinding;Landroid/widget/TextView;Landroid/widget/TextView;Lcom/cyber/azov2/DeterminantCircularProgressBar;)V
    .locals 0

    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    iput-object p1, p0, Lcom/example/guiproposal/databinding/ActivityMainBinding;->rootView:Landroidx/constraintlayout/widget/ConstraintLayout;

    .line 39
    iput-object p2, p0, Lcom/example/guiproposal/databinding/ActivityMainBinding;->included:Lcom/example/guiproposal/databinding/BottomSheetBinding;

    .line 40
    iput-object p3, p0, Lcom/example/guiproposal/databinding/ActivityMainBinding;->levelLabel:Landroid/widget/TextView;

    .line 41
    iput-object p4, p0, Lcom/example/guiproposal/databinding/ActivityMainBinding;->progressTv:Landroid/widget/TextView;

    .line 42
    iput-object p5, p0, Lcom/example/guiproposal/databinding/ActivityMainBinding;->progressbar:Lcom/cyber/azov2/DeterminantCircularProgressBar;

    return-void
.end method

.method public static bind(Landroid/view/View;)Lcom/example/guiproposal/databinding/ActivityMainBinding;
    .locals 8

    const v0, 0x7f0a00e9

    .line 73
    invoke-static {p0, v0}, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View;I)Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 77
    invoke-static {v1}, Lcom/example/guiproposal/databinding/BottomSheetBinding;->bind(Landroid/view/View;)Lcom/example/guiproposal/databinding/BottomSheetBinding;

    move-result-object v4

    const v0, 0x7f0a00fa

    .line 80
    invoke-static {p0, v0}, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View;I)Landroid/view/View;

    move-result-object v1

    move-object v5, v1

    check-cast v5, Landroid/widget/TextView;

    if-eqz v5, :cond_0

    const v0, 0x7f0a0162

    .line 86
    invoke-static {p0, v0}, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View;I)Landroid/view/View;

    move-result-object v1

    move-object v6, v1

    check-cast v6, Landroid/widget/TextView;

    if-eqz v6, :cond_0

    const v0, 0x7f0a0163

    .line 92
    invoke-static {p0, v0}, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View;I)Landroid/view/View;

    move-result-object v1

    move-object v7, v1

    check-cast v7, Lcom/cyber/azov2/DeterminantCircularProgressBar;

    if-eqz v7, :cond_0

    .line 97
    new-instance v0, Lcom/example/guiproposal/databinding/ActivityMainBinding;

    move-object v3, p0

    check-cast v3, Landroidx/constraintlayout/widget/ConstraintLayout;

    move-object v2, v0

    invoke-direct/range {v2 .. v7}, Lcom/example/guiproposal/databinding/ActivityMainBinding;-><init>(Landroidx/constraintlayout/widget/ConstraintLayout;Lcom/example/guiproposal/databinding/BottomSheetBinding;Landroid/widget/TextView;Landroid/widget/TextView;Lcom/cyber/azov2/DeterminantCircularProgressBar;)V

    return-object v0

    .line 100
    :cond_0
    invoke-virtual {p0}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object p0

    invoke-virtual {p0, v0}, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;

    move-result-object p0

    .line 101
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "Missing required view with ID: "

    invoke-virtual {v1, p0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static inflate(Landroid/view/LayoutInflater;)Lcom/example/guiproposal/databinding/ActivityMainBinding;
    .locals 2

    const/4 v0, 0x0

    const/4 v1, 0x0

    .line 53
    invoke-static {p0, v0, v1}, Lcom/example/guiproposal/databinding/ActivityMainBinding;->inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/example/guiproposal/databinding/ActivityMainBinding;

    move-result-object p0

    return-object p0
.end method

.method public static inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/example/guiproposal/databinding/ActivityMainBinding;
    .locals 2

    const v0, 0x7f0d001c

    const/4 v1, 0x0

    .line 59
    invoke-virtual {p0, v0, p1, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p0

    if-eqz p2, :cond_0

    .line 61
    invoke-virtual {p1, p0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 63
    :cond_0
    invoke-static {p0}, Lcom/example/guiproposal/databinding/ActivityMainBinding;->bind(Landroid/view/View;)Lcom/example/guiproposal/databinding/ActivityMainBinding;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public bridge synthetic getRoot()Landroid/view/View;
    .locals 1

    .line 19
    invoke-virtual {p0}, Lcom/example/guiproposal/databinding/ActivityMainBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;

    move-result-object v0

    return-object v0
.end method

.method public getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    .locals 1

    .line 48
    iget-object v0, p0, Lcom/example/guiproposal/databinding/ActivityMainBinding;->rootView:Landroidx/constraintlayout/widget/ConstraintLayout;

    return-object v0
.end method
