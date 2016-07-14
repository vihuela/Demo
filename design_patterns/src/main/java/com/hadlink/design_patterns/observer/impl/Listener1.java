package com.hadlink.design_patterns.observer.impl;

/**
 * @author ricky.yao on 2016/7/14.
 */
public class Listener1 {
    public void action() {
        System.out.println("我该认真听课了");
    }

    public void bb(String s) {
        System.out.println("放学啦：" + s);
    }
}
