package com.hadlink.design_patterns.proxy;

/**
 * @author Created by lyao on 2016/3/22.
 *         通知的通用抽取，具体逻辑省略
 */
public abstract class Notify {

    protected String tag;

    public Notify() {
        tag = getClass().getSimpleName();
    }

    public abstract void send();

    public abstract void cancel();

}
