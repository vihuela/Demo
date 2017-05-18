package com.hadlink.annotation.dagger.scene1;

import dagger.Component;

/**
 * @author ricky.yao on 2017/5/18.
 */

//Component标记接口，连接依赖对象和被依赖对象
@Component
public interface CarComponent {
    void inject(Car car);
}
