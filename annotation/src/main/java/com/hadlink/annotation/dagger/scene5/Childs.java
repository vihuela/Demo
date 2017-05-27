package com.hadlink.annotation.dagger.scene5;

import com.hadlink.annotation.dagger.scene5.child.Child0;
import com.hadlink.annotation.dagger.scene5.child.Child1;

import javax.inject.Inject;

/**
 * @author ricky.yao on 2017/5/27.
 */

public class Childs {


    @Inject
    public Child1 child1;

    @Inject
    public Child0 child0;
}
