package com.hadlink.design_patterns.status.impl;

import android.content.Context;
import android.widget.Toast;

import com.hadlink.design_patterns.status.interfaces.IAccountStatus;

/**
 * @author Created by lyao on 2016/3/21.
 */
public class LoginedState implements IAccountStatus {
    @Override public void forward(Context c) {
        Toast.makeText(c, "转发", Toast.LENGTH_SHORT).show();
    }

    @Override public void comment(Context c) {
        Toast.makeText(c, "评论", Toast.LENGTH_SHORT).show();
    }

    @Override public void star(Context c) {
        Toast.makeText(c, "点赞", Toast.LENGTH_SHORT).show();
    }
}
