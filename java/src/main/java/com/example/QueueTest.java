package com.example;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Created by lyao on 2016/3/28.
 * @description
 */
public class QueueTest {
    //    private static BlockingQueue<Request> blockingQueue = new LinkedBlockingQueue<>();
    private static BlockingQueue<Request> blockingQueue = new PriorityBlockingQueue<>();

    public static void main(String[] args) {

        /**
         * add
         */
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new Runnable() {
            @Override public void run() {
                while (true) {
                    try {
                        blockingQueue.put(new Request(new Random().nextInt(100)));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        /**
         * print
         */
        es.execute(new Runnable() {
            @Override public void run() {
                while (true) {
                    try {
                        Request take = blockingQueue.take();
                        System.out.println(take.priority);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }

    private static class Request implements Comparable<Request> {
        public int priority;

        public Request(int priority) {
            this.priority = priority;
        }

        /**
         * 针对PriorityBlockingQueue 优先级
         */
        @Override public int compareTo(Request o) {
//            return this.priority > o.priority ? 1 : this.priority < o.priority ? -1 : 0;
            return this.priority > o.priority ? -1 : this.priority < o.priority ? 1 : 0;
        }
    }
}
