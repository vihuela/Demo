package com.hadlink.measure.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.hadlink.measure.R;

/**
 * @author Created by lyao on 2016/2/3.
 */
public class ClockView extends View {

    private int smallCircleRadius;
    private int smallCircleOffset;
    private int arrowOffsetY;
    private int arrowOffsetX;
    private int contentSize;
    private Paint outCircleLinePaint;
    private Paint smallCirclePaint;
    private Paint arrowPaint;
    private Paint arrowCirclePaint;
    private Paint textPaint;
    private int canvasCount;
    private int lineLength;
    private int mCenterX, mCenterY;
    private Path arrowPath;
    /**
     * rotate canvas
     */
    private boolean isRotate;
    private double alpha;
    private float mTouchX;
    private float mTouchY;
    private float mCanvasRotateX = 0;
    private float mCanvasRotateY = 0;
    private float mCanvasMaxRotateDegree = 20;
    private Matrix mMatrix = new Matrix();
    private Camera mCamera = new Camera();

    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.clockView);
        isRotate = typedArray.getBoolean(typedArray.getIndex(R.styleable.clockView_isRotate), false);
        typedArray.recycle();
        canvasCount = 120;
        contentSize = Math.min(getResources().getDisplayMetrics().heightPixels, getResources().getDisplayMetrics().widthPixels);
        lineLength = getPx(context, 10f);
        smallCircleRadius = getPx(context, 10f) / 2;
        smallCircleOffset = 7;
        arrowOffsetY = 250;
        arrowOffsetX = 40;
        arrowPath = new Path();

        /**
         * 外圈圆小线条
         */
        outCircleLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        outCircleLinePaint.setStyle(Paint.Style.STROKE);
        outCircleLinePaint.setStrokeWidth(2.f);
        outCircleLinePaint.setColor(Color.WHITE);

        /**
         * 小圆圈
         */
        smallCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        smallCirclePaint.setColor(Color.WHITE);

        /**
         * 箭头
         */
        arrowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        arrowPaint.setColor(Color.WHITE);

        /**
         * 箭头内部圆圈
         */
        arrowCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        arrowCirclePaint.setColor(Color.parseColor("#AFD0E2"));

        /**
         * 文字
         */
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(getPx(context, 13f));

    }

    public static int getPx(Context ctx, float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, ctx.getResources().getDisplayMetrics());
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int spec = MeasureSpec.makeMeasureSpec(contentSize, MeasureSpec.EXACTLY);
        setMeasuredDimension(spec, spec);
    }

    @Override protected void onDraw(Canvas canvas) {
        /**
         * 内容区域
         */
        int contentX = (getWidth() - getPaddingLeft() - getPaddingRight()) / 2;
        int contentY = (getHeight() - getPaddingTop() - getPaddingBottom()) / 2;

        /**
         * 中心点
         */
        mCenterX = contentX + getPaddingLeft();
        mCenterY = contentY + getPaddingTop();

        /**
         * 旋转桌布
         */
        if (isRotate) {
            canvas.rotate((float) alpha, mCenterX, mCenterY);

            alpha = Math.atan((mTouchX - mCenterX) / (mCenterY - mTouchY));
            alpha = Math.toDegrees(alpha);
            if (mTouchY > mCenterY) {
                alpha = alpha + 180;
            }
            rotateCanvas(canvas);
        }


        /**
         * 最外圈
         */

        drawOutCircle(canvas, mCenterX, mCenterY);

        /**
         * 小圆圈
         */
        drawSmallCircle(canvas, mCenterX);

        /**
         * 文字
         */
        drawText(canvas);

        /**
         * 箭头
         */
        drawArrow(canvas);

        /**
         * 箭头中间圆圈
         */
        drawArrowCircle(canvas);

    }

    private void rotateCanvas(Canvas canvas) {
        mMatrix.reset();
        mCamera.save();
        mCamera.rotateX(mCanvasRotateX);
        mCamera.rotateY(mCanvasRotateY);
        mCamera.getMatrix(mMatrix);
        mCamera.restore();
        mMatrix.preTranslate(-mCenterX, -mCenterY);
        mMatrix.postTranslate(mCenterX, mCenterY);

        canvas.concat(mMatrix);
    }

    @Override public boolean onTouchEvent(MotionEvent event) {
        if (isRotate) {
            float x = event.getX();
            float y = event.getY();
            mTouchX = x;
            mTouchY = y;

            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN: {
                    rotateCanvasWhenMove(x, y);
                    return true;
                }
                case MotionEvent.ACTION_MOVE: {
                    rotateCanvasWhenMove(x, y);
                    invalidate();
                    return true;
                }
                case MotionEvent.ACTION_UP: {
                    mCanvasRotateY = 0;
                    mCanvasRotateX = 0;
                    invalidate();
                    return true;
                }
            }
        }
        return super.onTouchEvent(event);
    }

    private void rotateCanvasWhenMove(float x, float y) {
        float dx = x - mCenterX;
        float dy = y - mCenterY;

        float percentX = dx / mCenterX;
        float percentY = dy / mCenterY;

        if (percentX > 1f) {
            percentX = 1f;
        } else if (percentX < -1f) {
            percentX = -1f;
        }
        if (percentY > 1f) {
            percentY = 1f;
        } else if (percentY < -1f) {
            percentY = -1f;
        }

        mCanvasRotateY = mCanvasMaxRotateDegree * percentX;
        mCanvasRotateX = -(mCanvasMaxRotateDegree * percentY);
    }

    private void drawArrowCircle(Canvas canvas) {
        canvas.drawCircle(mCenterX, mCenterY, smallCircleRadius * 2, arrowCirclePaint);
    }

    private void drawArrow(Canvas canvas) {
        arrowPath.moveTo(mCenterX, mCenterY - arrowOffsetY);
        arrowPath.lineTo(mCenterX - arrowOffsetX, mCenterY);
        arrowPath.lineTo(mCenterX, mCenterY + arrowOffsetY);
        arrowPath.lineTo(mCenterX + arrowOffsetX, mCenterY);
        arrowPath.lineTo(mCenterX, mCenterY - arrowOffsetY);
        arrowPath.close();
        canvas.drawPath(arrowPath, arrowPaint);
    }

    private void drawText(Canvas canvas) {
        canvas.drawText("N", mCenterX - smallCircleRadius / 2, lineLength, textPaint);
    }


    private void drawSmallCircle(Canvas canvas, int centerX) {
        int smallCircleY = getPaddingTop() + lineLength + smallCircleRadius + smallCircleOffset;
        canvas.drawCircle(centerX, smallCircleY, smallCircleRadius, smallCirclePaint);
    }

    private void drawOutCircle(Canvas canvas, int centerX, int centerY) {
        canvas.save();
        for (int i = 0; i < canvasCount; i++) {
            int itemAlpha = (255 / canvasCount) * i;
            outCircleLinePaint.setAlpha(Math.min(255, 255 - itemAlpha));
            canvas.drawLine(centerX, getPaddingTop(), centerX, lineLength + getPaddingTop(), outCircleLinePaint);
            canvas.rotate(360 / canvasCount, centerX, centerY);
        }
        canvas.restore();
    }
}
