package com.cyber.azov2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;

/* loaded from: classes.dex */
public class DeterminantCircularProgressBar extends View {
    private float backgroundStrokeWidthPx;
    private float bodyStrokeWidthPx;
    private float paddingPx;
    private Paint paintBackground;
    private Paint paintBody;
    private RectF rect;
    private final float BODY_STROKE_WIDTH = 18.0f;
    private final float PADDING = 9.0f;
    private float startAngle = -90.0f;
    private float maxAngle = 360.0f;
    private int maxProgress = 100;
    private float diameter = 0.0f;
    private float angle = 0.0f;

    private void init() {
        int color = ResourcesCompat.getColor(getResources(), R.color.progress_track_color, null);
        int color2 = ResourcesCompat.getColor(getResources(), R.color.progress_indicator_color, null);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.bodyStrokeWidthPx = TypedValue.applyDimension(1, 18.0f, displayMetrics);
        this.paddingPx = TypedValue.applyDimension(1, 9.0f, displayMetrics);
        this.backgroundStrokeWidthPx = TypedValue.applyDimension(1, 18.0f, displayMetrics);
        this.rect = new RectF();
        Paint paint = new Paint();
        this.paintBody = paint;
        paint.setAntiAlias(true);
        this.paintBody.setColor(color);
        this.paintBody.setStrokeWidth(this.bodyStrokeWidthPx);
        this.paintBody.setStyle(Paint.Style.STROKE);
        this.paintBody.setStrokeJoin(Paint.Join.ROUND);
        this.paintBody.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.paintBackground = paint2;
        paint2.setColor(color2);
        this.paintBackground.setStrokeWidth(this.backgroundStrokeWidthPx);
        this.paintBackground.setStyle(Paint.Style.STROKE);
        this.paintBackground.setStrokeJoin(Paint.Join.ROUND);
        this.paintBackground.setStrokeCap(Paint.Cap.ROUND);
    }

    public DeterminantCircularProgressBar(Context context) {
        super(context);
        init();
    }

    public DeterminantCircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DeterminantCircularProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public DeterminantCircularProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.rotate(getRotation(), getWidth() / 2.0f, getHeight() / 2.0f);
        float f = this.paddingPx;
        this.rect.set(f, f, getWidth() - this.paddingPx, getHeight() - this.paddingPx);
        canvas.drawArc(this.rect, this.startAngle, this.maxAngle, false, this.paintBody);
        canvas.drawArc(this.rect, this.startAngle, this.angle, false, this.paintBackground);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.diameter = Math.min(getWidth(), getHeight());
        updateRect();
    }

    private float calculateAngle(float f) {
        return (this.maxAngle / this.maxProgress) * f;
    }

    private void updateRect() {
        float strokeWidth = this.paintBackground.getStrokeWidth();
        RectF rectF = this.rect;
        float f = this.diameter;
        rectF.set(strokeWidth, strokeWidth, f - strokeWidth, f - strokeWidth);
    }

    public void setProgress(float f) {
        this.angle = calculateAngle(f);
        invalidate();
    }

    public void setProgressColor(int i) {
        this.paintBody.setColor(i);
        invalidate();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.paintBackground.setColor(i);
        invalidate();
    }

    public void setProgressWidth(float f) {
        this.paintBody.setStrokeWidth(f);
        this.paintBackground.setStrokeWidth(f);
        updateRect();
        invalidate();
    }
}