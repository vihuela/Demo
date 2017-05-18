package com.hadlink.annotation.dagger.scene4;

import dagger.Component;

/**
 * @author ricky.yao on 2017/5/18.
 */
@Component(modules = {PeopleModule.class})
@PeopleModule.PeopleScore
public interface CountryComponent {
    void inject(Country c);
}
