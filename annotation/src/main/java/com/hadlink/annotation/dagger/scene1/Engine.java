package com.hadlink.annotation.dagger.scene1;

import javax.inject.Inject;

/**
 * @author ricky.yao on 2017/5/18.
 */
//Inject标记依赖对象，标记构造函数
public class Engine {
    @Inject
    Engine() {
    }

    public void run() {
        System.out.println("引擎转起来了~~~");
    }
}
