package com.hadlink.annotation.anno;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Created by lyao on 2016/3/17.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@EventBase(listenerType = View.OnLongClickListener.class, listenerSetter = "setOnLongClickListener", methodName = "onLongClick")
public @interface OnLongClick {
    int[] value();
}
