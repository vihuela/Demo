package com.hadlink.annotation.dagger.scene5;

import dagger.Subcomponent;

/**
 * @author ricky.yao on 2017/5/27.
 */
@Subcomponent(modules = {ChildModule.class})
public interface IComponentSub {

    void inject(Childs childs);
}
