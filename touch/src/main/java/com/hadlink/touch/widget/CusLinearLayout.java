package com.hadlink.touch.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
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

    @TargetApi(21)
    public CusLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("CusLinearLayout onInterceptTouchEvent MotionEvent.ACTION_DOWN");
            case MotionEvent.ACTION_MOVE:
                System.out.println("CusLinearLayout onInterceptTouchEvent MotionEvent.ACTION_MOVE");
            case MotionEvent.ACTION_UP:
                System.out.println("CusLinearLayout onInterceptTouchEvent MotionEvent.ACTION_UP");
            case MotionEvent.ACTION_CANCEL:
                System.out.println("CusLinearLayout onInterceptTouchEvent MotionEvent.ACTION_CANCEL");
        }
        return true;
    }

    @Override public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("CusLinearLayout dispatchTouchEvent MotionEvent.ACTION_DOWN");
            case MotionEvent.ACTION_MOVE:
                System.out.println("CusLinearLayout dispatchTouchEvent MotionEvent.ACTION_MOVE");
            case MotionEvent.ACTION_UP:
                System.out.println("CusLinearLayout dispatchTouchEvent MotionEvent.ACTION_UP");
            case MotionEvent.ACTION_CANCEL:
                System.out.println("CusLinearLayout dispatchTouchEvent MotionEvent.ACTION_CANCEL");
        }
        return super.dispatchTouchEvent(event);
    }



    @Override public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("CusLinearLayout onTouchEvent MotionEvent.ACTION_DOWN");
            case MotionEvent.ACTION_MOVE:
                System.out.println("CusLinearLayout onTouchEvent MotionEvent.ACTION_MOVE");
            case MotionEvent.ACTION_UP:
                System.out.println("CusLinearLayout onTouchEvent MotionEvent.ACTION_UP");
            case MotionEvent.ACTION_CANCEL:
                System.out.println("CusLinearLayout onTouchEvent MotionEvent.ACTION_CANCEL");
        }
        return true;
    }
}
