package com.hadlink.measure.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Created by lyao on 2016/1/29.
 * @description
 */
public class RadarView extends View {

    protected RectF rectF;
    protected Paint paint;

    public RadarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = Math.min(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
        setMeasuredDimension(i, i);
    }

    @Override protected void onDraw(Canvas canvas) {

        /**
         * need measure
         */
        if (rectF == null) {

            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();

            int contentWidth = getWidth() - paddingLeft - paddingRight;
            int contentHeight = getHeight() - paddingTop - paddingBottom;

            rectF = new RectF(paddingLeft, paddingTop, contentWidth + paddingLeft, contentHeight + paddingBottom);

        }
        paint.setColor(Color.YELLOW);

//        canvas.drawArc(rectF, 0, 90, true, paint);
        canvas.drawRect(rectF, paint);
    }
}
