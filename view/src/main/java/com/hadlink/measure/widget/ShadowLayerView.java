package com.hadlink.measure.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.hadlink.measure.R;

/**
 * @author Created by lyao on 2016/2/3.
 */
public class ShadowLayerView extends View {

    private Paint p;

    public ShadowLayerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setShadowLayer(10, 0, 0, Color.RED);
        p.setTextSize(getPx(context,38f));

    }

    public static int getPx(Context ctx, float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, ctx.getResources().getDisplayMetrics());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawText("Ricky Yao", 80, 300, p);
    }

}
