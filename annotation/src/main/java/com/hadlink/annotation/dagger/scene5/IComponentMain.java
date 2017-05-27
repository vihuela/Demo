package com.hadlink.annotation.dagger.scene5;

import dagger.Component;

/**
 * @author ricky.yao on 2017/5/27.
 */
@Component(modules = {MainModule.class})
public interface IComponentMain {
    void inject(Main a);


    IComponentSub plus(ChildModule childModule);

}
