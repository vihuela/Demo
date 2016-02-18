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
    private int sweepAngle = 45;
    private int startAngle = 0;//3'clock
    private int contentWidth, contentHeight;
    private int centerX, centerY;

    public RadarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void setSweepAngle(int sweepAngle) {
        this.sweepAngle = sweepAngle;
        postInvalidate();
    }

    public void scan() {

        ObjectAnimator sweepAnim = ObjectAnimator.ofInt(this, "sweepAngle", MAX);
        sweepAnim.setDuration(5000);
        sweepAnim.setRepeatMode(ObjectAnimator.RESTART);
        sweepAnim.setRepeatCount(ObjectAnimator.INFINITE);

        sweepAnim.start();


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

            centerX = contentWidth / 2 + paddingLeft;
            centerY = contentHeight / 2 + paddingTop;

            rectF = new RectF(paddingLeft, paddingTop, contentWidth + paddingLeft, contentHeight + paddingBottom);

            //圆心像四周渐变
            int[] colors = {adjustAlpha(Color.RED, 1.f), adjustAlpha(Color.RED, 0.66f), adjustAlpha(Color.RED, 0.33f)};
            float[] stops = {0.2f, 0.3f, 0.5f};
            arcPaint.setShader(new RadialGradient(centerX, centerY, centerY, colors, null, RadialGradient.TileMode.MIRROR));
            /*arcPaint.setShader(new SweepGradient(centerX, centerY,colors,null));*/

        }
        //扇形
        canvas.save();
        canvas.rotate(sweepAngle, centerX, centerY);
        canvas.drawArc(rectF, startAngle, sweepAngle, true, arcPaint);
        canvas.restore();


        //内外圈圆
        canvas.drawCircle(centerX, centerY, contentWidth / 2, linePaint);
        canvas.drawCircle(centerX, centerY, contentWidth / 4, linePaint);
        //横竖线
        canvas.drawLine(getPaddingLeft(), centerY, contentWidth + getPaddingRight(), centerY, linePaint);
        canvas.drawLine(centerX, getPaddingTop(), centerX, contentHeight + getPaddingBottom(), linePaint);
    }

    public int adjustAlpha(int color, float factor) {
        int alpha = Math.round(Color.alpha(color) * factor);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        return Color.argb(alpha, red, green, blue);
    }
}
