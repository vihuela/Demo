package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ricky.yao on 2017/7/4.
 */
//http://www.importnew.com/17006.html
public class GenericTest {
    public static void main(String[] args) {
        //A->B->C
        //super为了写入，右边是左边的父类【生产者】
        List<? super B> l12 = new ArrayList<B>();
        List<? super B> l13 = new ArrayList<C>();
        l13.add(new A());
        l13.add(new B());
//        l12.add(new C());ERROR
//        l13.add(new B());ERROR


        //extends为了读取，右边是左边的子类【消费者】
        List<? extends B> l4 = new ArrayList<B>();
        List<? extends B> l3 = new ArrayList<A>();

//        l2.add(new C());ERROR
        B b = l4.get(1);

        //【既是生产者，又是消费者】
        List<B> l5 = new ArrayList<B>();

    }


    public static class A extends B {
    }

    public static class B extends C {
    }

    public static class C {
    }
}
