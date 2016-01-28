package com.hadlink.measure.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * @author Created by lyao on 2016/1/27.
 * @description
 */
public class CusLinearLayout extends LinearLayout {
    public CusLinearLayout(Context context) {
        super(context);
    }

    public CusLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CusLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        System.out.println("CusLinearLayout:onSizeChanged");
    }
    @TargetApi(21)
    public CusLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widMode = MeasureSpec.getMode(widthMeasureSpec);
        switch (widMode) {
            case MeasureSpec.EXACTLY:
                System.out.println("CusLinearLayout:onMeasure:widMode:MeasureSpec.EXACTLY");
                break;
            case MeasureSpec.UNSPECIFIED:
                System.out.println("CusLinearLayout:onMeasure:widMode:MeasureSpec.UNSPECIFIED");
                break;
            case MeasureSpec.AT_MOST:
                System.out.println("CusLinearLayout:onMeasure:widMode:MeasureSpec.AT_MOST");
                break;
        }
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        switch (heightMode) {
            case MeasureSpec.EXACTLY:
                System.out.println("CusLinearLayout:onMeasure:heightMode:MeasureSpec.EXACTLY");
                break;
            case MeasureSpec.UNSPECIFIED:
                System.out.println("CusLinearLayout:onMeasure:heightMode:MeasureSpec.UNSPECIFIED");
                break;
            case MeasureSpec.AT_MOST:
                System.out.println("CusLinearLayout:onMeasure:heightMode:MeasureSpec.AT_MOST");
                break;
        }
    }

    @Override protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        System.out.println("CusLinearLayout:onLayout:" + changed);
    }
}
