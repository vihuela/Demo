package com.hadlink.annotation.dagger.scene2;

import javax.inject.Inject;

/**
 * @author ricky.yao on 2017/5/18.
 */

public class Parent {
    @Inject
    public Child child;

    public Parent() {
        DaggerParentComponent.builder().markChildModule(new MarkChildModule()).build().inject(this);
    }
}
