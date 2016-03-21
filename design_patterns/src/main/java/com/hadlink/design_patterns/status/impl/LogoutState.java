package com.hadlink.design_patterns.status.impl;

import android.content.Context;
import android.content.Intent;

import com.hadlink.design_patterns.status.LoginActivity;
import com.hadlink.design_patterns.status.interfaces.IAccountStatus;

/**
 * @author Created by lyao on 2016/3/21.
 */
public class LogoutState implements IAccountStatus {

    @Override public void forward(Context c) {
        goLoginAty(c);
    }

    @Override public void comment(Context c) {
        goLoginAty(c);
    }

    @Override public void star(Context c) {
        goLoginAty(c);
    }

    public void goLoginAty(Context c) {
        Intent intent = new Intent(c, LoginActivity.class);
        c.startActivity(intent);
    }
}
