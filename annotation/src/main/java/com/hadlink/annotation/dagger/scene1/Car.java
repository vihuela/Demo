package com.hadlink.annotation.dagger.scene1;

import javax.inject.Inject;

/**
 * @author ricky.yao on 2017/5/18.
 */

public class Car {
    @Inject
    Engine engine;

    public Car() {
        DaggerCarComponent.builder().build().inject(this);
    }

    public Engine getEngine() {
        return this.engine;
    }
}
