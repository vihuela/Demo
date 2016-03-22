package com.hadlink.design_patterns.visitor;

import com.hadlink.design_patterns.visitor.visitor.Visitor;
import com.hadlink.design_patterns.visitor.model.Engineer;
import com.hadlink.design_patterns.visitor.model.Manager;
import com.hadlink.design_patterns.visitor.model.Staff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Created by lyao on 2016/3/22.
 * @description
 */
public class BusinessReport {
    private List<Staff> staffList;

    public BusinessReport() {
        staffList = Collections.synchronizedList(new ArrayList<Staff>());
        staffList.add(new Engineer("lyao_egr_1"));
        staffList.add(new Engineer("lyao_egr_2"));
        staffList.add(new Engineer("lyao_egr_3"));
        staffList.add(new Manager("lyao_mgr_1"));
        staffList.add(new Manager("lyao_mgr_2"));
    }

    public void showReport(Visitor visitor) {
        for (Staff s : staffList) {
            s.accept(visitor);
        }
    }
}
