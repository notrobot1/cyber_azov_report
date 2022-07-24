.class public final Lcom/example/guiproposal/databinding/BottomSheetBinding;
.super Ljava/lang/Object;
.source "BottomSheetBinding.java"

# interfaces
.implements Landroidx/viewbinding/ViewBinding;


# instance fields
.field public final attackRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

.field public final bottomSheetLayout:Landroid/widget/LinearLayout;

.field public final performingAttackTv:Landroid/widget/TextView;

.field private final rootView:Landroid/widget/LinearLayout;

.field public final startStopButton:Lcom/google/android/material/button/MaterialButton;


# direct methods
.method private constructor <init>(Landroid/widget/LinearLayout;Landroidx/recyclerview/widget/RecyclerView;Landroid/widget/LinearLayout;Landroid/widget/TextView;Lcom/google/android/material/button/MaterialButton;)V
    .locals 0

    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput-object p1, p0, Lcom/example/guiproposal/databinding/BottomSheetBinding;->rootView:Landroid/widget/LinearLayout;

    .line 40
    iput-object p2, p0, Lcom/example/guiproposal/databinding/BottomSheetBinding;->attackRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    .line 41
    iput-object p3, p0, Lcom/example/guiproposal/databinding/BottomSheetBinding;->bottomSheetLayout:Landroid/widget/LinearLayout;

    .line 42
    iput-object p4, p0, Lcom/example/guiproposal/databinding/BottomSheetBinding;->performingAttackTv:Landroid/widget/TextView;

    .line 43
    iput-object p5, p0, Lcom/example/guiproposal/databinding/BottomSheetBinding;->startStopButton:Lcom/google/android/material/button/MaterialButton;

    return-void
.end method

.method public static bind(Landroid/view/View;)Lcom/example/guiproposal/databinding/BottomSheetBinding;
    .locals 8

    const v0, 0x7f0a0053

    .line 74
    invoke-static {p0, v0}, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View;I)Landroid/view/View;

    move-result-object v1

    move-object v4, v1

    check-cast v4, Landroidx/recyclerview/widget/RecyclerView;

    if-eqz v4, :cond_0

    .line 79
    move-object v5, p0

    check-cast v5, Landroid/widget/LinearLayout;

    const v0, 0x7f0a015c

    .line 82
    invoke-static {p0, v0}, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View;I)Landroid/view/View;

    move-result-object v1

    move-object v6, v1

    check-cast v6, Landroid/widget/TextView;

    if-eqz v6, :cond_0

    const v0, 0x7f0a01a6

    .line 88
    invoke-static {p0, v0}, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View;I)Landroid/view/View;

    move-result-object v1

    move-object v7, v1

    check-cast v7, Lcom/google/android/material/button/MaterialButton;

    if-eqz v7, :cond_0

    .line 93
    new-instance p0, Lcom/example/guiproposal/databinding/BottomSheetBinding;

    move-object v2, p0

    move-object v3, v5

    invoke-direct/range {v2 .. v7}, Lcom/example/guiproposal/databinding/BottomSheetBinding;-><init>(Landroid/widget/LinearLayout;Landroidx/recyclerview/widget/RecyclerView;Landroid/widget/LinearLayout;Landroid/widget/TextView;Lcom/google/android/material/button/MaterialButton;)V

    return-object p0

    .line 96
    :cond_0
    invoke-virtual {p0}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object p0

    invoke-virtual {p0, v0}, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;

    move-result-object p0

    .line 97
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "Missing required view with ID: "

    invoke-virtual {v1, p0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static inflate(Landroid/view/LayoutInflater;)Lcom/example/guiproposal/databinding/BottomSheetBinding;
    .locals 2

    const/4 v0, 0x0

    const/4 v1, 0x0

    .line 54
    invoke-static {p0, v0, v1}, Lcom/example/guiproposal/databinding/BottomSheetBinding;->inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/example/guiproposal/databinding/BottomSheetBinding;

    move-result-object p0

    return-object p0
.end method

.method public static inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/example/guiproposal/databinding/BottomSheetBinding;
    .locals 2

    const v0, 0x7f0d001e

    const/4 v1, 0x0

    .line 60
    invoke-virtual {p0, v0, p1, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p0

    if-eqz p2, :cond_0

    .line 62
    invoke-virtual {p1, p0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 64
    :cond_0
    invoke-static {p0}, Lcom/example/guiproposal/databinding/BottomSheetBinding;->bind(Landroid/view/View;)Lcom/example/guiproposal/databinding/BottomSheetBinding;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public bridge synthetic getRoot()Landroid/view/View;
    .locals 1

    .line 20
    invoke-virtual {p0}, Lcom/example/guiproposal/databinding/BottomSheetBinding;->getRoot()Landroid/widget/LinearLayout;

    move-result-object v0

    return-object v0
.end method

.method public getRoot()Landroid/widget/LinearLayout;
    .locals 1

    .line 49
    iget-object v0, p0, Lcom/example/guiproposal/databinding/BottomSheetBinding;->rootView:Landroid/widget/LinearLayout;

    return-object v0
.end method
