package com.hadlink.measure.widget;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * @author Created by lyao on 2016/2/17.
 * @description
 */
public class VDHLayout extends RelativeLayout {

    private ViewDragHelper mDragHelper;
    private VDHCallBack mVDHCall;
    private RadarView rv1, rv2, rv3;
    private Point rv1Point = new Point();

    public VDHLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mVDHCall = new VDHCallBack();
        mDragHelper = ViewDragHelper.create(this, 1.f, mVDHCall);
    }

    @Override public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override public boolean onTouchEvent(MotionEvent event) {
        mDragHelper.processTouchEvent(event);
        return true;
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        rv1 = (RadarView) getChildAt(1);
        rv2 = (RadarView) getChildAt(0);
        rv3 = (RadarView) getChildAt(2);
    }

    @Override protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        /**
         * 记录rv1原始坐标
         */
        rv1Point.x = rv1.getLeft();
        rv1Point.y = rv1.getRight();
    }

    @Override public void computeScroll() {
        if (mDragHelper.continueSettling(true)) {
            postInvalidate();
        }
    }

    private class VDHCallBack extends ViewDragHelper.Callback {

        /**
         * which child use VDH handle
         */
        @Override public boolean tryCaptureView(View child, int pointerId) {
            return rv1 == child || rv3 == child;
        }

        @Override public int clampViewPositionVertical(View child, int top, int dy) {
            final int TOP_BOUND = getPaddingTop();
            final int BOTTOM_BOUND = getHeight() - child.getHeight() - getPaddingTop();

            if (top < TOP_BOUND) return TOP_BOUND;
            else if (top > BOTTOM_BOUND) return BOTTOM_BOUND;
            else return top;
        }

        @Override public int clampViewPositionHorizontal(View child, int left, int dx) {
            final int LEFT_BOUND = getPaddingLeft();
            final int RIGHT_BOUND = getWidth() - child.getWidth() - getPaddingRight();

            if (left < LEFT_BOUND) return LEFT_BOUND;
            else if (left > RIGHT_BOUND) return RIGHT_BOUND;
            else return left;
        }

        @Override public void onViewReleased(View releasedChild, float xvel, float yvel) {
            /**
             * 归位rv1
             */
            if (releasedChild == rv1) {
                mDragHelper.settleCapturedViewAt(rv1Point.x, rv1Point.y);
                postInvalidate();
            }
        }
    }
}
