package com.hadlink.annotation.dagger.scene5;

import com.hadlink.annotation.dagger.scene5.child.Child0;

import javax.inject.Inject;

/**
 * @author ricky.yao on 2017/5/27.
 */

public class Main {
    @Inject
    public IComponentMain iComponentMain;
    public Main(){
        DaggerIComponentMain.builder().mainModule(new MainModule()).build().inject(this);
    }
}
