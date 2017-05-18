package com.hadlink.annotation.dagger.scene4;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;
import javax.inject.Scope;

import dagger.Module;
import dagger.Provides;

/**
 * @author ricky.yao on 2017/5/18.
 */
//PeopleScore标记范围
@Module
public class PeopleModule {

    @Provides
    @PeopleScore
    @QuaPeop1
    public People getPeople1() {
        return new People("jack");
    }

    @Provides
    @PeopleScore
    @QuaPeop2
    public People getPeople2() {
        return new People("rose");
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface QuaPeop1 {
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface QuaPeop2 {
    }

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PeopleScore {
    }
}
