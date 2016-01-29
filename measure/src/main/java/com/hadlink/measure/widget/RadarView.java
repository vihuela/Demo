package com.hadlink.measure.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Created by lyao on 2016/1/29.
 * @description
 */
public class RadarView extends View {

    public final static int MAX = 360;
    protected RectF rectF;
    protected Paint arcPaint;
    protected Paint linePaint;
    protected int screenWidth;
    private int radius;
    private int startAngle;
    private int contentWidth, contentHeight;

    public RadarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void setRadius(int radius) {
        this.radius = radius;
        this.startAngle = radius + 45;
        postInvalidate();
    }

    public void scan() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(this, "radius", MAX);
        objectAnimator.setDuration(1500);
        objectAnimator.setRepeatMode(ObjectAnimator.RESTART);
        objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        objectAnimator.start();
/*
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofInt(this, "startAngle", MAX);
        objectAnimator1.setDuration(3000);
        objectAnimator1.setInterpolator(new DecelerateInterpolator());
        objectAnimator1.setRepeatMode(ObjectAnimator.RESTART);
        objectAnimator1.setRepeatCount(ObjectAnimator.INFINITE);
        objectAnimator1.start();*/
    }

    private void init(Context c) {

        arcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        arcPaint.setStyle(Paint.Style.FILL);
        arcPaint.setColor(Color.BLACK);
        arcPaint.setAlpha(128);

        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(1f);
        linePaint.setColor(Color.BLACK);

        screenWidth = c.getResources().getDisplayMetrics().widthPixels;
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = Math.min(MeasureSpec.getSize(widthMeasureSpec), screenWidth / 2);
        setMeasuredDimension(i, i);
    }


    @Override protected void onDraw(Canvas canvas) {

        if (rectF == null) {

            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();

            contentWidth = getWidth() - paddingLeft - paddingRight;
            contentHeight = getHeight() - paddingTop - paddingBottom;

            rectF = new RectF(paddingLeft, paddingTop, contentWidth + paddingLeft, contentHeight + paddingBottom);

            int[] colors = {adjustAlpha(Color.RED, 0.9f), adjustAlpha(Color.RED, 0.5f), adjustAlpha(Color.RED, 0.3f)};
            float[] stops = {0.2f, 0.3f, 0.5f};
            arcPaint.setShader(new RadialGradient(contentWidth / 2, contentHeight / 2, contentHeight / 2, colors, null, RadialGradient.TileMode.MIRROR));

        }
        //内外圈圆
        canvas.drawCircle(contentWidth / 2, contentHeight / 2, contentHeight / 2, linePaint);
        canvas.drawCircle(contentWidth / 2, contentHeight / 2, contentHeight / 2 / 2, linePaint);
        //横竖线
        canvas.drawLine(0, contentHeight / 2, contentWidth, contentHeight / 2, linePaint);
        canvas.drawLine(contentWidth / 2, 0, contentWidth / 2, contentHeight, linePaint);
        //扇形
        canvas.drawArc(rectF, startAngle, 45, true, arcPaint);
    }

    public int adjustAlpha(int color, float factor) {
        int alpha = Math.round(Color.alpha(color) * factor);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        return Color.argb(alpha, red, green, blue);
    }
}
