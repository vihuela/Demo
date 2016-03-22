package com.hadlink.design_patterns.visitor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hadlink.design_patterns.visitor.visitor.CEOVisitor;
import com.hadlink.design_patterns.visitor.visitor.CTOVisitor;

/**
 * @author Created by lyao on 2016/3/22.
 * @description
 */
public class VisitorMainAty extends AppCompatActivity {


    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BusinessReport businessReport = new BusinessReport();
        businessReport.showReport(new CEOVisitor());
        businessReport.showReport(new CTOVisitor());
    }


}
