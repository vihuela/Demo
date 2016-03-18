package com.hadlink.annotation;

import android.app.Activity;
import android.view.View;

import com.hadlink.annotation.anno.ContentView;
import com.hadlink.annotation.anno.EventBase;
import com.hadlink.annotation.anno.ViewInject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Created by lyao on 2016/3/17.
 */
public class ViewInjectUtils {
    public final static String SetContentView = "setContentView";
    public final static String FindViewById = "findViewById";

    public static void injectContentView(Activity activity) {
        try {
            Class<? extends Activity> clz = activity.getClass();
            ContentView contentView = clz.getAnnotation(ContentView.class);
            if (contentView != null) {
                int layoutId = contentView.value();
                Method setContentViewMethod = clz.getMethod(SetContentView, int.class);
                setContentViewMethod.setAccessible(true);
                setContentViewMethod.invoke(activity, layoutId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void injectView(Activity activity) {
        try {
            Class<? extends Activity> clz = activity.getClass();
            Field[] declaredFields = clz.getDeclaredFields();
            for (Field f : declaredFields) {
                ViewInject viewInject = f.getAnnotation(ViewInject.class);
                if (viewInject != null) {
                    int widgetId = viewInject.value();
                    Method findViewByIdMethod = clz.getMethod(FindViewById, int.class);
                    Object widget = findViewByIdMethod.invoke(activity, widgetId);
                    f.setAccessible(true);
                    f.set(activity, widget);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 目标tv.setOnClickListener(this);
     */
    public static void injectOnClick(Activity activity) {

        Class<? extends Activity> clz = activity.getClass();
        Method[] methods = clz.getMethods();
        for (Method m : methods) {
            Annotation[] annotations = m.getAnnotations();
            for (Annotation annotation : annotations) {
                Class<? extends Annotation> annotationType = annotation.annotationType();//注解的注解 获取方式注意
                /**
                 * 存在注解的注解
                 */
                EventBase eventBase = annotationType.getAnnotation(EventBase.class);
                if (eventBase != null) {

                    Class<?> listenerType = eventBase.listenerType();//View.OnClickListener.class
                    String listenerSetter = eventBase.listenerSetter();//setOnClickListener
                    String methodName = eventBase.methodName();//onClick

                    try {
                        /**
                         * int value()方法
                         */
                        Method aMethod = annotationType.getMethod("value");
                        int[] widgetIds = (int[]) aMethod.invoke(annotation);

                        /**
                         * View.OnClickListener.class的实例
                         */
                        DynamicHandler dynamicHandler = new DynamicHandler(activity);
                        dynamicHandler.addMethod(methodName, m);
                        Object listener = Proxy.newProxyInstance(listenerType.getClassLoader(),
                                new Class[]{listenerType},
                                dynamicHandler);

                        for (int id : widgetIds) {
                            /**
                             * 执行tv.setOnClickListener(this);
                             * 关键在this，需要是接口的匿名内部实现类。
                             */
                            View view = activity.findViewById(id);
                            Method listenerSetterMethod = view.getClass().getMethod(listenerSetter, listenerType);
                            listenerSetterMethod.invoke(view, listener);

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            }

        }

    }
}
