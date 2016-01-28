package com.hadlink.measure.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author Created by lyao on 2016/1/27.
 * @description
 */
public class CusTextView extends TextView {
    public CusTextView(Context context) {
        super(context);
    }

    public CusTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CusTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public CusTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        System.out.println("CusTextView:onSizeChanged");
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widMode = MeasureSpec.getMode(widthMeasureSpec);
        switch (widMode) {
            case MeasureSpec.EXACTLY:
                System.out.println("CusTextView:onMeasure:widMode:MeasureSpec.EXACTLY");
                break;
            case MeasureSpec.UNSPECIFIED:
                System.out.println("CusTextView:onMeasure:widMode:MeasureSpec.UNSPECIFIED");
                break;
            case MeasureSpec.AT_MOST:
                System.out.println("CusTextView:onMeasure:widMode:MeasureSpec.AT_MOST");
                break;
        }
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        switch (heightMode) {
            case MeasureSpec.EXACTLY:
                System.out.println("CusTextView:onMeasure:heightMode:MeasureSpec.EXACTLY");
                break;
            case MeasureSpec.UNSPECIFIED:
                System.out.println("CusTextView:onMeasure:heightMode:MeasureSpec.UNSPECIFIED");
                break;
            case MeasureSpec.AT_MOST:
                System.out.println("CusTextView:onMeasure:heightMode:MeasureSpec.AT_MOST");
                break;
        }
    }

    @Override protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        System.out.println("CusTextView:onLayout:" + changed);
    }
}
