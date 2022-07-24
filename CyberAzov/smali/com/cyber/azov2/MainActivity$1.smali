.class Lcom/cyber/azov2/MainActivity$1;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/cyber/azov2/MainActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/cyber/azov2/MainActivity;


# direct methods
.method constructor <init>(Lcom/cyber/azov2/MainActivity;)V
    .locals 0

    .line 56
    iput-object p1, p0, Lcom/cyber/azov2/MainActivity$1;->this$0:Lcom/cyber/azov2/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    const-wide/16 v0, 0x3e8

    .line 60
    :try_start_0
    iget-object v2, p0, Lcom/cyber/azov2/MainActivity$1;->this$0:Lcom/cyber/azov2/MainActivity;

    invoke-static {v2}, Lcom/cyber/azov2/MainActivity;->-$$Nest$fgettimeElapsed(Lcom/cyber/azov2/MainActivity;)I

    move-result v3

    add-int/lit8 v3, v3, 0x1

    invoke-static {v2, v3}, Lcom/cyber/azov2/MainActivity;->-$$Nest$fputtimeElapsed(Lcom/cyber/azov2/MainActivity;I)V

    .line 61
    iget-object v2, p0, Lcom/cyber/azov2/MainActivity$1;->this$0:Lcom/cyber/azov2/MainActivity;

    invoke-static {v2}, Lcom/cyber/azov2/MainActivity;->-$$Nest$mupdateProgressBarText(Lcom/cyber/azov2/MainActivity;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 63
    iget-object v2, p0, Lcom/cyber/azov2/MainActivity$1;->this$0:Lcom/cyber/azov2/MainActivity;

    invoke-static {v2}, Lcom/cyber/azov2/MainActivity;->-$$Nest$fgethandler(Lcom/cyber/azov2/MainActivity;)Landroid/os/Handler;

    move-result-object v2

    invoke-virtual {v2, p0, v0, v1}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    return-void

    :catchall_0
    move-exception v2

    iget-object v3, p0, Lcom/cyber/azov2/MainActivity$1;->this$0:Lcom/cyber/azov2/MainActivity;

    invoke-static {v3}, Lcom/cyber/azov2/MainActivity;->-$$Nest$fgethandler(Lcom/cyber/azov2/MainActivity;)Landroid/os/Handler;

    move-result-object v3

    invoke-virtual {v3, p0, v0, v1}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 64
    throw v2
.end method
