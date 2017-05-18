package com.hadlink.annotation.dagger.scene2;

import dagger.Component;

/**
 * @author ricky.yao on 2017/5/18.
 */
@Component(modules = {MarkChildModule.class})
public interface ParentComponent {
    void inject(Parent p);
}
