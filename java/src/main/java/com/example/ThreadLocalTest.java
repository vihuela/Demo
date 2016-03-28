package com.example;

/**
 * @author Created by lyao on 2016/3/28.
 */
public class ThreadLocalTest {

    /**
     * 这种所有线程都有
     */
   /* private static ThreadLocal<String> threadLocalInit = new ThreadLocal<String>() {
        @Override protected String initialValue() {
            return "asjs";
        }
    };*/
    private static ThreadLocal<String> threadLocalNone = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocalNone.set("demaxiya");
        System.out.println(getExist());
        new Thread(new Runnable() {
            @Override public void run() {
                System.out.println(getExist());
            }
        }).start();
    }

    private static String getExist() {
        return Thread.currentThread().getName() + " " + (threadLocalNone.get() != null);
    }
}
