package com.hadlink.annotation.dagger.scene4;

import javax.inject.Inject;

/**
 * @author ricky.yao on 2017/5/18.
 */

public class Country {
    @PeopleModule.QuaPeop1
    @Inject
    public People people1;

    @Inject
    @PeopleModule.QuaPeop1
    public People people2;

    public Country() {
        DaggerCountryComponent.builder().peopleModule(new PeopleModule()).build().inject(this);
    }

}
