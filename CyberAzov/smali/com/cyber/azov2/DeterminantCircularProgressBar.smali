.class public Lcom/cyber/azov2/DeterminantCircularProgressBar;
.super Landroid/view/View;
.source "DeterminantCircularProgressBar.java"


# instance fields
.field private final BODY_STROKE_WIDTH:F

.field private final PADDING:F

.field private angle:F

.field private backgroundStrokeWidthPx:F

.field private bodyStrokeWidthPx:F

.field private diameter:F

.field private maxAngle:F

.field private maxProgress:I

.field private paddingPx:F

.field private paintBackground:Landroid/graphics/Paint;

.field private paintBody:Landroid/graphics/Paint;

.field private rect:Landroid/graphics/RectF;

.field private startAngle:F


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .line 75
    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    const/high16 p1, 0x41900000    # 18.0f

    .line 19
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->BODY_STROKE_WIDTH:F

    const/high16 p1, 0x41100000    # 9.0f

    .line 20
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->PADDING:F

    const/high16 p1, -0x3d4c0000    # -90.0f

    .line 30
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->startAngle:F

    const/high16 p1, 0x43b40000    # 360.0f

    .line 31
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->maxAngle:F

    const/16 p1, 0x64

    .line 32
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->maxProgress:I

    const/4 p1, 0x0

    .line 34
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->diameter:F

    .line 35
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->angle:F

    .line 76
    invoke-direct {p0}, Lcom/cyber/azov2/DeterminantCircularProgressBar;->init()V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .line 80
    invoke-direct {p0, p1, p2}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    const/high16 p1, 0x41900000    # 18.0f

    .line 19
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->BODY_STROKE_WIDTH:F

    const/high16 p1, 0x41100000    # 9.0f

    .line 20
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->PADDING:F

    const/high16 p1, -0x3d4c0000    # -90.0f

    .line 30
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->startAngle:F

    const/high16 p1, 0x43b40000    # 360.0f

    .line 31
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->maxAngle:F

    const/16 p1, 0x64

    .line 32
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->maxProgress:I

    const/4 p1, 0x0

    .line 34
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->diameter:F

    .line 35
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->angle:F

    .line 81
    invoke-direct {p0}, Lcom/cyber/azov2/DeterminantCircularProgressBar;->init()V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .line 85
    invoke-direct {p0, p1, p2, p3}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    const/high16 p1, 0x41900000    # 18.0f

    .line 19
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->BODY_STROKE_WIDTH:F

    const/high16 p1, 0x41100000    # 9.0f

    .line 20
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->PADDING:F

    const/high16 p1, -0x3d4c0000    # -90.0f

    .line 30
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->startAngle:F

    const/high16 p1, 0x43b40000    # 360.0f

    .line 31
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->maxAngle:F

    const/16 p1, 0x64

    .line 32
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->maxProgress:I

    const/4 p1, 0x0

    .line 34
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->diameter:F

    .line 35
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->angle:F

    .line 86
    invoke-direct {p0}, Lcom/cyber/azov2/DeterminantCircularProgressBar;->init()V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;II)V
    .locals 0

    .line 90
    invoke-direct {p0, p1, p2, p3, p4}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;II)V

    const/high16 p1, 0x41900000    # 18.0f

    .line 19
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->BODY_STROKE_WIDTH:F

    const/high16 p1, 0x41100000    # 9.0f

    .line 20
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->PADDING:F

    const/high16 p1, -0x3d4c0000    # -90.0f

    .line 30
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->startAngle:F

    const/high16 p1, 0x43b40000    # 360.0f

    .line 31
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->maxAngle:F

    const/16 p1, 0x64

    .line 32
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->maxProgress:I

    const/4 p1, 0x0

    .line 34
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->diameter:F

    .line 35
    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->angle:F

    .line 91
    invoke-direct {p0}, Lcom/cyber/azov2/DeterminantCircularProgressBar;->init()V

    return-void
.end method

.method private calculateAngle(F)F
    .locals 2

    .line 130
    iget v0, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->maxAngle:F

    iget v1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->maxProgress:I

    int-to-float v1, v1

    div-float/2addr v0, v1

    mul-float/2addr v0, p1

    return v0
.end method

.method private init()V
    .locals 6

    .line 39
    invoke-virtual {p0}, Lcom/cyber/azov2/DeterminantCircularProgressBar;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f060252

    const/4 v2, 0x0

    .line 38
    invoke-static {v0, v1, v2}, Landroidx/core/content/res/ResourcesCompat;->getColor(Landroid/content/res/Resources;ILandroid/content/res/Resources$Theme;)I

    move-result v0

    .line 42
    invoke-virtual {p0}, Lcom/cyber/azov2/DeterminantCircularProgressBar;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v3, 0x7f060251

    .line 41
    invoke-static {v1, v3, v2}, Landroidx/core/content/res/ResourcesCompat;->getColor(Landroid/content/res/Resources;ILandroid/content/res/Resources$Theme;)I

    move-result v1

    .line 44
    invoke-virtual {p0}, Lcom/cyber/azov2/DeterminantCircularProgressBar;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    const/4 v3, 0x1

    const/high16 v4, 0x41900000    # 18.0f

    .line 45
    invoke-static {v3, v4, v2}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v5

    iput v5, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->bodyStrokeWidthPx:F

    const/high16 v5, 0x41100000    # 9.0f

    .line 48
    invoke-static {v3, v5, v2}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v5

    iput v5, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->paddingPx:F

    .line 51
    invoke-static {v3, v4, v2}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v2

    iput v2, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->backgroundStrokeWidthPx:F

    .line 55
    new-instance v2, Landroid/graphics/RectF;

    invoke-direct {v2}, Landroid/graphics/RectF;-><init>()V

    iput-object v2, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->rect:Landroid/graphics/RectF;

    .line 57
    new-instance v2, Landroid/graphics/Paint;

    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    iput-object v2, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->paintBody:Landroid/graphics/Paint;

    .line 58
    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 59
    iget-object v2, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->paintBody:Landroid/graphics/Paint;

    invoke-virtual {v2, v0}, Landroid/graphics/Paint;->setColor(I)V

    .line 60
    iget-object v0, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->paintBody:Landroid/graphics/Paint;

    iget v2, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->bodyStrokeWidthPx:F

    invoke-virtual {v0, v2}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 61
    iget-object v0, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->paintBody:Landroid/graphics/Paint;

    sget-object v2, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v2}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 62
    iget-object v0, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->paintBody:Landroid/graphics/Paint;

    sget-object v2, Landroid/graphics/Paint$Join;->ROUND:Landroid/graphics/Paint$Join;

    invoke-virtual {v0, v2}, Landroid/graphics/Paint;->setStrokeJoin(Landroid/graphics/Paint$Join;)V

    .line 63
    iget-object v0, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->paintBody:Landroid/graphics/Paint;

    sget-object v2, Landroid/graphics/Paint$Cap;->ROUND:Landroid/graphics/Paint$Cap;

    invoke-virtual {v0, v2}, Landroid/graphics/Paint;->setStrokeCap(Landroid/graphics/Paint$Cap;)V

    .line 65
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->paintBackground:Landroid/graphics/Paint;

    .line 66
    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 67
    iget-object v0, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->paintBackground:Landroid/graphics/Paint;

    iget v1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->backgroundStrokeWidthPx:F

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 68
    iget-object v0, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->paintBackground:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 69
    iget-object v0, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->paintBackground:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Join;->ROUND:Landroid/graphics/Paint$Join;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeJoin(Landroid/graphics/Paint$Join;)V

    .line 70
    iget-object v0, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->paintBackground:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Cap;->ROUND:Landroid/graphics/Paint$Cap;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeCap(Landroid/graphics/Paint$Cap;)V

    return-void
.end method

.method private updateRect()V
    .locals 4

    .line 134
    iget-object v0, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->paintBackground:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v0

    .line 135
    iget-object v1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->rect:Landroid/graphics/RectF;

    iget v2, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->diameter:F

    sub-float v3, v2, v0

    sub-float/2addr v2, v0

    invoke-virtual {v1, v0, v0, v3, v2}, Landroid/graphics/RectF;->set(FFFF)V

    return-void
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 10

    .line 96
    invoke-virtual {p0}, Lcom/cyber/azov2/DeterminantCircularProgressBar;->getRotation()F

    move-result v0

    invoke-virtual {p0}, Lcom/cyber/azov2/DeterminantCircularProgressBar;->getWidth()I

    move-result v1

    int-to-float v1, v1

    const/high16 v2, 0x40000000    # 2.0f

    div-float/2addr v1, v2

    invoke-virtual {p0}, Lcom/cyber/azov2/DeterminantCircularProgressBar;->getHeight()I

    move-result v3

    int-to-float v3, v3

    div-float/2addr v3, v2

    invoke-virtual {p1, v0, v1, v3}, Landroid/graphics/Canvas;->rotate(FFF)V

    .line 98
    iget v0, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->paddingPx:F

    .line 100
    invoke-virtual {p0}, Lcom/cyber/azov2/DeterminantCircularProgressBar;->getWidth()I

    move-result v1

    int-to-float v1, v1

    iget v3, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->paddingPx:F

    sub-float/2addr v1, v3

    .line 101
    invoke-virtual {p0}, Lcom/cyber/azov2/DeterminantCircularProgressBar;->getHeight()I

    move-result v3

    int-to-float v3, v3

    iget v4, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->paddingPx:F

    sub-float/2addr v3, v4

    .line 103
    iget-object v4, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->rect:Landroid/graphics/RectF;

    invoke-virtual {v4, v0, v0, v1, v3}, Landroid/graphics/RectF;->set(FFFF)V

    .line 105
    iget-object v5, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->rect:Landroid/graphics/RectF;

    iget v6, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->startAngle:F

    iget v7, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->maxAngle:F

    iget-object v9, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->paintBody:Landroid/graphics/Paint;

    const/4 v8, 0x0

    move-object v4, p1

    invoke-virtual/range {v4 .. v9}, Landroid/graphics/Canvas;->drawArc(Landroid/graphics/RectF;FFZLandroid/graphics/Paint;)V

    .line 113
    iget-object v5, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->rect:Landroid/graphics/RectF;

    iget v6, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->startAngle:F

    iget v7, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->angle:F

    iget-object v9, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->paintBackground:Landroid/graphics/Paint;

    invoke-virtual/range {v4 .. v9}, Landroid/graphics/Canvas;->drawArc(Landroid/graphics/RectF;FFZLandroid/graphics/Paint;)V

    return-void
.end method

.method protected onSizeChanged(IIII)V
    .locals 0

    .line 124
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/View;->onSizeChanged(IIII)V

    .line 125
    invoke-virtual {p0}, Lcom/cyber/azov2/DeterminantCircularProgressBar;->getWidth()I

    move-result p1

    invoke-virtual {p0}, Lcom/cyber/azov2/DeterminantCircularProgressBar;->getHeight()I

    move-result p2

    invoke-static {p1, p2}, Ljava/lang/Math;->min(II)I

    move-result p1

    int-to-float p1, p1

    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->diameter:F

    .line 126
    invoke-direct {p0}, Lcom/cyber/azov2/DeterminantCircularProgressBar;->updateRect()V

    return-void
.end method

.method public setBackgroundColor(I)V
    .locals 1

    .line 149
    iget-object v0, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->paintBackground:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setColor(I)V

    .line 150
    invoke-virtual {p0}, Lcom/cyber/azov2/DeterminantCircularProgressBar;->invalidate()V

    return-void
.end method

.method public setProgress(F)V
    .locals 0

    .line 139
    invoke-direct {p0, p1}, Lcom/cyber/azov2/DeterminantCircularProgressBar;->calculateAngle(F)F

    move-result p1

    iput p1, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->angle:F

    .line 140
    invoke-virtual {p0}, Lcom/cyber/azov2/DeterminantCircularProgressBar;->invalidate()V

    return-void
.end method

.method public setProgressColor(I)V
    .locals 1

    .line 144
    iget-object v0, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->paintBody:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setColor(I)V

    .line 145
    invoke-virtual {p0}, Lcom/cyber/azov2/DeterminantCircularProgressBar;->invalidate()V

    return-void
.end method

.method public setProgressWidth(F)V
    .locals 1

    .line 154
    iget-object v0, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->paintBody:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 155
    iget-object v0, p0, Lcom/cyber/azov2/DeterminantCircularProgressBar;->paintBackground:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 156
    invoke-direct {p0}, Lcom/cyber/azov2/DeterminantCircularProgressBar;->updateRect()V

    .line 157
    invoke-virtual {p0}, Lcom/cyber/azov2/DeterminantCircularProgressBar;->invalidate()V

    return-void
.end method
