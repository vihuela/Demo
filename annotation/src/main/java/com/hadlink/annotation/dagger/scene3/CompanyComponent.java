package com.hadlink.annotation.dagger.scene3;

import dagger.Component;

/**
 * @author ricky.yao on 2017/5/18.
 */
@Component(modules = {StaffModule.class})
public interface CompanyComponent {
    void inject(Company c);
}
