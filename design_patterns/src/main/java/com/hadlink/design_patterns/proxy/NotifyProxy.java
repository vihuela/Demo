package com.hadlink.design_patterns.proxy;

import android.os.Build;

import com.hadlink.design_patterns.proxy.impl.NotifyBig;
import com.hadlink.design_patterns.proxy.impl.NotifyHeadUp;
import com.hadlink.design_patterns.proxy.impl.NotifyNormal;

/**
 * @author Created by lyao on 2016/3/22.
 */
public class NotifyProxy extends Notify {

    private Notify notify;

    public NotifyProxy() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            notify = new NotifyHeadUp();
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            notify = new NotifyBig();
        } else {
            notify = new NotifyNormal();
        }
    }

    @Override public void send() {
        notify.send();
    }

    @Override public void cancel() {
        notify.cancel();
    }
}
