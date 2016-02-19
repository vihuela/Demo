package com.hadlink.measure.widget;

import android.content.Context;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

/**
 * @author Created by lyao on 2016/2/18.
 * @description http://blog.csdn.net/guolin_blog/article/details/48719871
 */
public class ScrollerLayout extends ViewGroup {

    private int downX = 0, downY = 0;
    /**
     * 左右边界
     */
    private int mLeftBound, mRightBound;
    /**
     * 最小移动像素
     */
    private int mTouchSlop;
    private int downRowX;


    public ScrollerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
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
        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                downRowX = (int) ev.getRawX();
                break;
            case MotionEvent.ACTION_MOVE:
                int distanceX = Math.abs((int) ev.getRawX() - downRowX);
                downRowX = (int) ev.getRawX();
                boolean r = distanceX > mTouchSlop;
                return r;
        }
        return false;
    }

    @Override public boolean onTouchEvent(MotionEvent event) {


        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                downX = (int) event.getRawX();
                break;
            case MotionEvent.ACTION_MOVE:
                int distanceX = (int) event.getRawX() - downX;

                downX = (int) event.getRawX();

                scrollBy(-distanceX, 0);

                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return true;
    }
}
