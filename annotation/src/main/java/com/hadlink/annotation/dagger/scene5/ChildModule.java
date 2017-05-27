package com.hadlink.annotation.dagger.scene5;

import com.hadlink.annotation.dagger.scene5.child.Child1;

import dagger.Module;
import dagger.Provides;

/**
 * @author ricky.yao on 2017/5/27.
 */
@Module
public class ChildModule {

    @Provides
    public Child1 getChild1() {
        return new Child1();
    }

}
