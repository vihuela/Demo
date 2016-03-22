package com.hadlink.design_patterns.visitor.visitor;

import com.hadlink.design_patterns.visitor.model.Engineer;
import com.hadlink.design_patterns.visitor.model.Manager;

/**
 * @author Created by lyao on 2016/3/22.
 * @description
 */
public class CEOVisitor implements Visitor {
    @Override public void visit(Engineer engineer) {
        System.out.println("ceo:" + "员工:" + engineer.name + " kpi:" + engineer.kpi);
    }

    @Override public void visit(Manager manager) {
        System.out.println("ceo:" + "员工:" + manager.name + " kpi:" + manager.kpi);
    }
}
