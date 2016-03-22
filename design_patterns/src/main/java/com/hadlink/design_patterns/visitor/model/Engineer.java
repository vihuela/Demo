package com.hadlink.design_patterns.visitor.model;

import com.hadlink.design_patterns.visitor.visitor.Visitor;

import java.security.SecureRandom;

/**
 * @author Created by lyao on 2016/3/22.
 *         工程师
 */
public class Engineer extends Staff {
    public Engineer(String name) {
        super(name);
    }

    @Override public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getCodeLines() {
        return new SecureRandom().nextInt(10 * 10000);
    }
}
