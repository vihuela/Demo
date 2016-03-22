package com.hadlink.design_patterns.visitor.model;

import com.hadlink.design_patterns.visitor.visitor.Visitor;

import java.security.SecureRandom;

/**
 * @author Created by lyao on 2016/3/22.
 * @description
 */
public abstract class Staff {
    public String name;
    public int kpi;

    public Staff(String name) {
        this.name = name;
        this.kpi = new SecureRandom().nextInt(10);
    }

    /**
     * 接收Visitor的访问
     */
    public abstract void accept(Visitor visitor);
}
