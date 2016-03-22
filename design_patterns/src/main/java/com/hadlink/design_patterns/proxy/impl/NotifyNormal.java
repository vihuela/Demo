package com.hadlink.design_patterns.proxy.impl;

import com.hadlink.design_patterns.proxy.Notify;

/**
 * @author Created by lyao on 2016/3/22.
 * @description
 */
public class NotifyNormal extends Notify {
    @Override public void send() {
        System.out.println(tag+" send");
    }

    @Override public void cancel() {
        System.out.println(tag+" cancel");
    }
}
