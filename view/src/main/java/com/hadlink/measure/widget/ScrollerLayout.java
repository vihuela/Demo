package com.hadlink.measure.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Created by lyao on 2016/2/18.
 * @description
 */
public class ScrollerLayout extends ViewGroup {

    private int downX = 0, downY = 0;
    /**
     * 左右边界
     */
    private int mLeftBound, mRightBound;

    public ScrollerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            measureChild(getChildAt(i), widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (changed) {
            for (int i = 0; i < getChildCount(); i++) {
                View item = getChildAt(i);
                item.layout(item.getMeasuredWidth() * i, getPaddingTop(), item.getMeasuredWidth() * i + item.getMeasuredWidth(), item.getMeasuredHeight());
            }
            mLeftBound = getChildAt(0).getLeft();
            mRightBound = getChildAt(getChildCount() - 1).getRight();
        }
    }

    @Override public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override public boolean onTouchEvent(MotionEvent event) {


        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                downX = (int) event.getX();
                downY = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int distanceX = (int) event.getX() - downX;
                int distanceY = (int) event.getY() - downY;

                downX = (int) event.getX();
                downY = (int) event.getY();
                
                scrollBy(distanceX, 0);

                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return true;
    }
}
