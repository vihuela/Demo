package com.hadlink.annotation.dagger.scene3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

import dagger.Module;
import dagger.Provides;

/**
 * @author ricky.yao on 2017/5/18.
 */
//Qualifier标记，Provides唯一性
@Module
public class StaffModule {

    @Provides
    @QualifierJuniorStaff
    Staff getJuniorStaff() {
        return new Staff(5);
    }

    @Provides
    @QualifierSeniorStaff
    Staff getSeniorStaff() {
        return new Staff(15);
    }


    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface QualifierJuniorStaff {
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface QualifierSeniorStaff {
    }
}

