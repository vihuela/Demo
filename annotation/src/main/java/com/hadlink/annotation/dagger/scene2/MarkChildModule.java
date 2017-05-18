package com.hadlink.annotation.dagger.scene2;

import dagger.Module;
import dagger.Provides;

/**
 * @author ricky.yao on 2017/5/18.
 */
//Module标记多参的被依赖对象，Provides则做连接用处，连接主体的inject注解需要的依赖对象
@Module
public class MarkChildModule {
    @Provides
    Child getChild() {
        return new Child("apple");
    }
}
