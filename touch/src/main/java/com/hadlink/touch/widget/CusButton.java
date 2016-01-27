package com.hadlink.touch.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
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
    }

    @Override public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("CusButton dispatchTouchEvent MotionEvent.ACTION_DOWN");
            case MotionEvent.ACTION_MOVE:
                System.out.println("CusButton dispatchTouchEvent MotionEvent.ACTION_MOVE");
            case MotionEvent.ACTION_UP:
                System.out.println("CusButton dispatchTouchEvent MotionEvent.ACTION_UP");
            case MotionEvent.ACTION_CANCEL:
                System.out.println("CusButton dispatchTouchEvent MotionEvent.ACTION_CANCEL");
        }
        return super.dispatchTouchEvent(event);
    }

    @Override public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("CusButton onTouchEvent MotionEvent.ACTION_DOWN");
            case MotionEvent.ACTION_MOVE:
                System.out.println("CusButton onTouchEvent MotionEvent.ACTION_MOVE");
            case MotionEvent.ACTION_UP:
                System.out.println("CusButton onTouchEvent MotionEvent.ACTION_UP");
            case MotionEvent.ACTION_CANCEL:
                System.out.println("CusButton onTouchEvent MotionEvent.ACTION_CANCEL");
        }
        return super.onTouchEvent(event);
    }
}
