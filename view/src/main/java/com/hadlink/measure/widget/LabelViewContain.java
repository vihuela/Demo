package com.hadlink.measure.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author ricky.yao on 2017/5/8.
 */

public class LabelViewContain extends ViewGroup {

    private int mLineMargin;
    private int mWordMargin;

    public LabelViewContain(Context context) {
        this(context, null);
    }

    public LabelViewContain(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LabelViewContain(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getAttrs(context, attrs);
    }

    private void getAttrs(Context context, AttributeSet attrs) {

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int count = getChildCount();
        int maxWidth = MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft() - getPaddingRight();

        int contentHeight = 0; //记录内容的高度
        int lineWidth = 0; //记录行的宽度
        int maxLineWidth = 0; //记录最宽的行宽
        int maxItemHeight = 0; //记录一行中item高度最大的高度
        boolean begin = true; //是否是行的开头

        for (int i = 0; i < count; i++) {
            View view = getChildAt(i);
            measureChild(view, widthMeasureSpec, heightMeasureSpec);

            //换行检测
            if (maxWidth < lineWidth + view.getMeasuredWidth()) {
                contentHeight += mLineMargin;
                contentHeight += maxItemHeight;
                maxItemHeight = 0;
                maxLineWidth = Math.max(maxLineWidth, lineWidth);
                lineWidth = 0;
                begin = true;
            }
            maxItemHeight = Math.max(maxItemHeight, view.getMeasuredHeight());
            if (!begin) {
                lineWidth += mWordMargin;
            } else {
                begin = false;
            }
            lineWidth += view.getMeasuredWidth();
        }

        contentHeight += maxItemHeight;
        maxLineWidth = Math.max(maxLineWidth, lineWidth);

        setMeasuredDimension(measureWidth(widthMeasureSpec, maxLineWidth),
                measureHeight(heightMeasureSpec, contentHeight));

    }

    private int measureWidth(int measureSpec, int contentWidth) {
        int result;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = contentWidth + getPaddingLeft() + getPaddingRight();
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        result = Math.max(result, getSuggestedMinimumWidth());
        return result;
    }

    private int measureHeight(int measureSpec, int contentHeight) {
        int result;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = contentHeight + getPaddingTop() + getPaddingBottom();
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        result = Math.max(result, getSuggestedMinimumHeight());
        return result;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {


        int left = getPaddingLeft();
        int top = getPaddingTop();
        int maxItemWidth = 0;//item最大宽度
        int maxItemHeight = 0;//item最大高度

        int contentWidth = r - l;
        for (int i = 0; i < getChildCount(); i++) {
            View item = getChildAt(i);
            View item_pre = getChildAt(i - 1);

            maxItemHeight = Math.max(maxItemHeight, item.getMeasuredHeight());
            maxItemWidth = Math.max(maxItemWidth, item.getMeasuredWidth());

            //换行情况一：item宽度超过内容宽度（bug = =！）
            if (item.getMeasuredWidth() == contentWidth - getPaddingLeft() - getPaddingRight()) {
                left = getPaddingLeft();
                if (item_pre != null) {
                    top = getPaddingTop();
                    top += item_pre.getTop() + item.getMeasuredHeight() - getPaddingTop();
                }

            }
            //换行情况二：item累加宽度超过内容宽度
            else if (contentWidth < left + item.getMeasuredWidth() + getPaddingRight()) {
                left = getPaddingLeft();
                top += maxItemHeight;
                maxItemHeight = 0;
            }

            item.layout(left, top, left + item.getMeasuredWidth(), top + item.getMeasuredHeight());
            left += item.getMeasuredWidth();

        }
    }

}
