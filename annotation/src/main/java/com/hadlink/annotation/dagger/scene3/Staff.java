package com.hadlink.annotation.dagger.scene3;

/**
 * @author ricky.yao on 2017/5/18.
 */

public class Staff {
    public int skill;//技能指数

    public Staff(int s) {
        this.skill = s;
    }

    @Override
    public String toString() {
        return "this is (" + (this.skill > 10 ? "senior" : "junior") + ") Staff，skill is:" + skill;
    }
}
