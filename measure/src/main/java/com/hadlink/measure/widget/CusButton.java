package com.hadlink.measure.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * @author Created by lyao on 2016/1/27.
 * @description
 */
public class CusButton extends Button {
    public CusButton(Context context) {
        super(context);
    }

    public CusButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CusButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public CusButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }@Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        System.out.println("CusButton:onSizeChanged");
    }
    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widMode = MeasureSpec.getMode(widthMeasureSpec);
        switch (widMode) {
            case MeasureSpec.EXACTLY:
                System.out.println("CusButton:onMeasure:widMode:MeasureSpec.EXACTLY");
                break;
            case MeasureSpec.UNSPECIFIED:
                System.out.println("CusButton:onMeasure:widMode:MeasureSpec.UNSPECIFIED");
                break;
            case MeasureSpec.AT_MOST:
                System.out.println("CusButton:onMeasure:widMode:MeasureSpec.AT_MOST");
                break;
        }
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        switch (heightMode) {
            case MeasureSpec.EXACTLY:
                System.out.println("CusButton:onMeasure:heightMode:MeasureSpec.EXACTLY");
                break;
            case MeasureSpec.UNSPECIFIED:
                System.out.println("CusButton:onMeasure:heightMode:MeasureSpec.UNSPECIFIED");
                break;
            case MeasureSpec.AT_MOST:
                System.out.println("CusButton:onMeasure:heightMode:MeasureSpec.AT_MOST");
                break;
        }
    }

    @Override protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        System.out.println("CusButton:onLayout:" + changed);
    }

}
