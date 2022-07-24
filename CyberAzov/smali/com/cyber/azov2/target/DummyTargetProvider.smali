.class public Lcom/cyber/azov2/target/DummyTargetProvider;
.super Ljava/lang/Object;
.source "DummyTargetProvider.java"

# interfaces
.implements Lcom/cyber/azov2/target/TargetProvider;


# static fields
.field private static final targets:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 12

    .line 8
    new-instance v0, Ljava/util/ArrayList;

    const-string v1, "https://targetone.ru"

    const-string v2, "https://targettwo.ru"

    const-string v3, "https://targetthree.ru"

    const-string v4, "https://targetfour.ru"

    const-string v5, "https://targetfive.ru"

    const-string v6, "https://targetsix.ru"

    const-string v7, "https://targetseven.ru"

    const-string v8, "https://targeteight.ru"

    const-string v9, "https://targetnine.ru"

    const-string v10, "https://targetten.ru"

    const-string v11, "https://targeteleven.ru"

    filled-new-array/range {v1 .. v11}, [Ljava/lang/String;

    move-result-object v1

    .line 9
    invoke-static {v1}, Lcom/cyber/azov2/target/DummyTargetProvider$$ExternalSyntheticBackport0;->m([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    sput-object v0, Lcom/cyber/azov2/target/DummyTargetProvider;->targets:Ljava/util/List;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public provideTargets()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 27
    sget-object v0, Lcom/cyber/azov2/target/DummyTargetProvider;->targets:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->shuffle(Ljava/util/List;)V

    const/4 v1, 0x0

    const/16 v2, 0xa

    .line 28
    invoke-interface {v0, v1, v2}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method
