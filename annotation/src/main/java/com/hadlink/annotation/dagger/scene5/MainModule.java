package com.hadlink.annotation.dagger.scene5;

import com.hadlink.annotation.dagger.scene5.child.Child0;

import dagger.Module;
import dagger.Provides;

/**
 * @author ricky.yao on 2017/5/27.
 */
@Module
public class MainModule {

    @Provides
    public Child0 getChild0() {
        return new Child0();
    }

}
