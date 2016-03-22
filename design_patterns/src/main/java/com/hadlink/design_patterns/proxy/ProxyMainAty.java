package com.hadlink.design_patterns.proxy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author Created by lyao on 2016/3/22.
 * @description
 */
public class ProxyMainAty extends AppCompatActivity {
    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NotifyProxy notifyProxy = new NotifyProxy();
        notifyProxy.send();
    }
}
