package com.hadlink.annotation.dagger.scene2;

import android.text.TextUtils;

/**
 * @author ricky.yao on 2017/5/18.
 */

public class Child {
    String food;

    Child() {
    }


    Child(String food) {
        this.food = food;
    }

    public void eat() {
        System.out.println("eat " + (TextUtils.isEmpty(food) ? "none" : food));
    }
}
