package com.hadlink.annotation.anno;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author Created by lyao on 2016/3/17.
 */
public class DynamicHandler implements InvocationHandler {
    private final HashMap<String, Method> methodMap = new HashMap<>(1);
    private WeakReference<Object> handlerRef;

    public DynamicHandler(Object handler) {
        this.handlerRef = new WeakReference<>(handler);
    }

    public void addMethod(String name, Method method) {
        methodMap.put(name, method);
    }

    public Object getHandler() {
        return handlerRef.get();
    }

    public void setHandler(Object handler) {
        this.handlerRef = new WeakReference<>(handler);
    }

    /**
     * view.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {

    }
    });
     */
    /**
     * 这里拦截的是
     * 接口实现类的方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        //proxy就是本身，做分析用，因无法拦截getClass()
        Object handler = handlerRef.get();
        if (handler != null) {
            String methodName = method.getName();
            method = methodMap.get(methodName);
            if (method != null) {
                return method.invoke(handler, args);
            }
        }
        return null;
    }
}
