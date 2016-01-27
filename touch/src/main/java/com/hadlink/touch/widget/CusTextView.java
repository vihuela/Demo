package com.hadlink.touch.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
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
    @Override public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("CusTextView dispatchTouchEvent MotionEvent.ACTION_DOWN");
            case MotionEvent.ACTION_MOVE:
                System.out.println("CusTextView dispatchTouchEvent MotionEvent.ACTION_MOVE");
            case MotionEvent.ACTION_UP:
                System.out.println("CusTextView dispatchTouchEvent MotionEvent.ACTION_UP");
            case MotionEvent.ACTION_CANCEL:
                System.out.println("CusTextView dispatchTouchEvent MotionEvent.ACTION_CANCEL");
        }
        return super.dispatchTouchEvent(event);
    }

    @Override public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("CusTextView onTouchEvent MotionEvent.ACTION_DOWN");
            case MotionEvent.ACTION_MOVE:
                System.out.println("CusTextView onTouchEvent MotionEvent.ACTION_MOVE");
            case MotionEvent.ACTION_UP:
                System.out.println("CusTextView onTouchEvent MotionEvent.ACTION_UP");
            case MotionEvent.ACTION_CANCEL:
                System.out.println("CusTextView onTouchEvent MotionEvent.ACTION_CANCEL");
        }
        return super.onTouchEvent(event);
    }
}
