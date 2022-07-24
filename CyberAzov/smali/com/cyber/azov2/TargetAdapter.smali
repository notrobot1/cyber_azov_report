.class public Lcom/cyber/azov2/TargetAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "TargetAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/cyber/azov2/TargetAdapter$ViewHolder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroidx/recyclerview/widget/RecyclerView$Adapter<",
        "Lcom/cyber/azov2/TargetAdapter$ViewHolder;",
        ">;"
    }
.end annotation


# instance fields
.field private targets:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .line 17
    invoke-direct {p0}, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/cyber/azov2/TargetAdapter;->targets:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public getItemCount()I
    .locals 1

    .line 41
    iget-object v0, p0, Lcom/cyber/azov2/TargetAdapter;->targets:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public bridge synthetic onBindViewHolder(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V
    .locals 0

    .line 13
    check-cast p1, Lcom/cyber/azov2/TargetAdapter$ViewHolder;

    invoke-virtual {p0, p1, p2}, Lcom/cyber/azov2/TargetAdapter;->onBindViewHolder(Lcom/cyber/azov2/TargetAdapter$ViewHolder;I)V

    return-void
.end method

.method public onBindViewHolder(Lcom/cyber/azov2/TargetAdapter$ViewHolder;I)V
    .locals 1

    .line 36
    iget-object v0, p0, Lcom/cyber/azov2/TargetAdapter;->targets:Ljava/util/List;

    invoke-virtual {p1, p2, v0}, Lcom/cyber/azov2/TargetAdapter$ViewHolder;->bind(ILjava/util/List;)V

    return-void
.end method

.method public bridge synthetic onCreateViewHolder(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    .locals 0

    .line 13
    invoke-virtual {p0, p1, p2}, Lcom/cyber/azov2/TargetAdapter;->onCreateViewHolder(Landroid/view/ViewGroup;I)Lcom/cyber/azov2/TargetAdapter$ViewHolder;

    move-result-object p1

    return-object p1
.end method

.method public onCreateViewHolder(Landroid/view/ViewGroup;I)Lcom/cyber/azov2/TargetAdapter$ViewHolder;
    .locals 1

    .line 30
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object p2

    invoke-static {p2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object p2

    const/4 v0, 0x0

    invoke-static {p2, p1, v0}, Lcom/example/guiproposal/databinding/RecyclerItemBinding;->inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/example/guiproposal/databinding/RecyclerItemBinding;

    move-result-object p1

    .line 31
    new-instance p2, Lcom/cyber/azov2/TargetAdapter$ViewHolder;

    invoke-direct {p2, p1}, Lcom/cyber/azov2/TargetAdapter$ViewHolder;-><init>(Lcom/example/guiproposal/databinding/RecyclerItemBinding;)V

    return-object p2
.end method

.method public setTargets(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .line 22
    iput-object p1, p0, Lcom/cyber/azov2/TargetAdapter;->targets:Ljava/util/List;

    .line 23
    invoke-virtual {p0}, Lcom/cyber/azov2/TargetAdapter;->notifyDataSetChanged()V

    return-void
.end method
