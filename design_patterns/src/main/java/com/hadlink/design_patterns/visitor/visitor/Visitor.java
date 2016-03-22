package com.hadlink.design_patterns.visitor.visitor;

import com.hadlink.design_patterns.visitor.model.Engineer;
import com.hadlink.design_patterns.visitor.model.Manager;

/**
 * @author Created by lyao on 2016/3/22.
 */
public interface Visitor {

    /**
     * 访问工程师类型
     */
    void visit(Engineer engineer);

    /**
     * 访问经理类型
     */
    void visit(Manager manager);
}
