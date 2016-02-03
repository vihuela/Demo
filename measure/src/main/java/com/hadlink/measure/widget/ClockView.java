package com.hadlink.measure.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * @author Created by lyao on 2016/2/3.
 * @description
 */
public class ClockView extends View {
    private int radius;//半径
    private int contentSize;//内容区域大小
    private Paint circlePaint;
    private Context mContext;
    private int canvasCount;//表盘小刻度线条绘制次数
    private int lineLength;//表盘小刻度线条长度

    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        canvasCount = 60;
        contentSize = Math.min(getResources().getDisplayMetrics().heightPixels, getResources().getDisplayMetrics().widthPixels);
        lineLength = getPx(mContext, 10f);
        radius = contentSize / 2 - lineLength - 10;// -  parentPadding;

        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeWidth(2.f);
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
        int px = contentX + getPaddingLeft();
        int py = contentY + getPaddingTop();

        canvas.save();
        for (int i = 0; i < canvasCount; i++) {
            canvas.drawLine(px, getPaddingTop(), px, lineLength + getPaddingTop(), circlePaint);
            canvas.rotate(360 / canvasCount, px, py);
        }
        canvas.restore();


    }
}
