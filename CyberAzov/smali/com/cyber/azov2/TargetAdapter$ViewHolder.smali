.class public Lcom/cyber/azov2/TargetAdapter$ViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "TargetAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/cyber/azov2/TargetAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ViewHolder"
.end annotation


# instance fields
.field private binding:Lcom/example/guiproposal/databinding/RecyclerItemBinding;


# direct methods
.method public constructor <init>(Lcom/example/guiproposal/databinding/RecyclerItemBinding;)V
    .locals 1

    .line 47
    invoke-virtual {p1}, Lcom/example/guiproposal/databinding/RecyclerItemBinding;->getRoot()Landroid/widget/FrameLayout;

    move-result-object v0

    invoke-direct {p0, v0}, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    .line 48
    iput-object p1, p0, Lcom/cyber/azov2/TargetAdapter$ViewHolder;->binding:Lcom/example/guiproposal/databinding/RecyclerItemBinding;

    return-void
.end method


# virtual methods
.method public bind(ILjava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .line 52
    invoke-interface {p2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    .line 53
    iget-object p2, p0, Lcom/cyber/azov2/TargetAdapter$ViewHolder;->binding:Lcom/example/guiproposal/databinding/RecyclerItemBinding;

    iget-object p2, p2, Lcom/example/guiproposal/databinding/RecyclerItemBinding;->attackUrlName:Landroid/widget/TextView;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "> "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p2, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method
