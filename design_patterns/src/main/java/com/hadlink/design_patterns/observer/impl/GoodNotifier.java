package com.hadlink.design_patterns.observer.impl;

import com.hadlink.design_patterns.observer.update.Notifier;

/**
 * @author ricky.yao on 2016/7/14.
 */
public class GoodNotifier extends Notifier {
    @Override
    public void addListener(Object object, String methodName, Object... args) {
        getEventHandler().addEvent(object, methodName, args);
    }

    @Override
    public void notifyX() {
        try {
            getEventHandler().notifyX();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
