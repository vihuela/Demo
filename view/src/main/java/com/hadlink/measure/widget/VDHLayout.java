package com.hadlink.measure.widget;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.hadlink.measure.R;

/**
 * @author Created by lyao on 2016/2/17.
 * @description
 */
public class VDHLayout extends FrameLayout {

    private ViewDragHelper mDragHelper;
    private VDHCallBack mVDHCall;

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

    private class VDHCallBack extends ViewDragHelper.Callback {

        /**
         * which child use VDH handle
         */
        @Override public boolean tryCaptureView(View child, int pointerId) {
            return child.getId() == R.id.rv;
        }

        @Override public int clampViewPositionVertical(View child, int top, int dy) {

            return top;
        }

        @Override public int clampViewPositionHorizontal(View child, int left, int dx) {
            int leftBound = left < 0 ? 0 : left;
            return leftBound;
        }

        @Override public int getViewVerticalDragRange(View child) {
            return super.getViewVerticalDragRange(child);
        }

        @Override public int getViewHorizontalDragRange(View child) {
            return super.getViewHorizontalDragRange(child);
        }

    }
}
