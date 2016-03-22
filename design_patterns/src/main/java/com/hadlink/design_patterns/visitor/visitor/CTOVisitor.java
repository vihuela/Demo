package com.hadlink.design_patterns.visitor.visitor;

import com.hadlink.design_patterns.visitor.model.Engineer;
import com.hadlink.design_patterns.visitor.model.Manager;

/**
 * @author Created by lyao on 2016/3/22.
 */
public class CTOVisitor implements Visitor {
    @Override public void visit(Engineer engineer) {
        System.out.println("cto:" + "员工:" + engineer.name + " 编码量：" + engineer.getCodeLines());
    }

    @Override public void visit(Manager manager) {
        System.out.println("cto:" + "员工:" + manager.name + " 产品量：" + manager.getProducts());

    }
}
