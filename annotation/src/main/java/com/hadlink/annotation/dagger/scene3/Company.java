package com.hadlink.annotation.dagger.scene3;

import javax.inject.Inject;

/**
 * @author ricky.yao on 2017/5/18.
 */

public class Company {
    @Inject
    @StaffModule.QualifierJuniorStaff
     Staff JuniorStaff;

    @Inject
    @StaffModule.QualifierSeniorStaff
     Staff SeniorStaff;

    public Company() {
        DaggerCompanyComponent.builder().staffModule(new StaffModule()).build().inject(this);
    }

    public void printJuniorStaff() {
        System.out.println(JuniorStaff);
    }

    public void printSeniorStaff() {
        System.out.println(SeniorStaff);
    }

}
