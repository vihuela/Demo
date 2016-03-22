package com.hadlink.design_patterns.visitor.model;

import com.hadlink.design_patterns.visitor.visitor.Visitor;

import java.security.SecureRandom;

/**
 * @author Created by lyao on 2016/3/22.
 *         产品经理
 */
public class Manager extends Staff {
    private int products;//产品数量

    public Manager(String name) {
        super(name);
    }

    @Override public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getProducts() {
        return products * new SecureRandom().nextInt();
    }
}
