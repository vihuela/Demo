package com.hadlink.measure.widget;

import android.content.Context;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * @author Created by lyao on 2016/2/18.
 * @description http://blog.csdn.net/guolin_blog/article/details/48719871
 */
public class ScrollerLayout extends ViewGroup {

    private final static int TIME = 1000;
    private final Scroller mScroller;
    private final VelocityTracker mTracker;
    /**
     * 原始左右边界
     */
    private int mLeftRestoreBound, mRightRestoreBound;

    /**
     * 左右移动的偏移量
     */
    private int mTargetOffset;

    /**
     * 最小移动像素
     */
    private int mTouchSlop;

    private int downX, downInterceptX;
    private int itemMeasuredWidth;

    /**
     * 每个item的边界
     */
    private int[] boundArr;


    public ScrollerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
        mScroller = new Scroller(context);
        mTracker = VelocityTracker.obtain();
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            measureChild(getChildAt(i), widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (changed) {
            boundArr = new int[getChildCount()];
            for (int i = 0; i < getChildCount(); i++) {
                View item = getChildAt(i);
                item.layout(item.getMeasuredWidth() * i, getPaddingTop(), item.getMeasuredWidth() * i + item.getMeasuredWidth(), item.getMeasuredHeight());
                boundArr[i] = item.getLeft();
            }
            itemMeasuredWidth = getChildAt(0).getMeasuredWidth();

            mLeftRestoreBound = getChildAt(0).getLeft();
            mRightRestoreBound = getChildAt(getChildCount() - 1).getRight() - itemMeasuredWidth;


            mTargetOffset = /*itemMeasuredWidth/2*/0;

        }
    }

    @Override public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                downInterceptX = (int) ev.getRawX();
                downX = downInterceptX;//first down handle by childView
                break;
            case MotionEvent.ACTION_MOVE:
                int distanceX = Math.abs((int) ev.getRawX() - downInterceptX);
                downInterceptX = (int) ev.getRawX();

                return distanceX > 0;
        }
        return false;
    }

    @Override public boolean onTouchEvent(MotionEvent event) {
        mTracker.addMovement(event);
        boolean direct;
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                downX = (int) event.getRawX();

                break;
            case MotionEvent.ACTION_MOVE:
                int distanceX = (int) event.getRawX() - downX;
                downX = (int) event.getRawX();

                /*boolean canScroll = getScrollX() >= mLeftMoveBound && getScrollX() <= mRightMoveBound;
                if (canScroll) scrollBy(-distanceX, 0);*/

                scrollBy(-distanceX, 0);

                break;
            case MotionEvent.ACTION_UP:

                scroll();

                break;
        }
        return super.onTouchEvent(event);
    }

    private void scroll() {

        mTracker.computeCurrentVelocity(TIME);
        float xVelocity = mTracker.getXVelocity();

        int targetIndex = (getScrollX() + mTargetOffset) / itemMeasuredWidth;
        int dx = targetIndex * itemMeasuredWidth - getScrollX();
        mScroller.startScroll(getScrollX(), 0, dx, 0, TIME);
        postInvalidate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }

}
