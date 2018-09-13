package com.yibo.leetcode.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        PoolDemo poolDemo = new PoolDemo();
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int k = 0; k < 10; k++) {
            threadPool.submit(() -> {
                int i = poolDemo.getI();
                while (i <= 100) {
                    poolDemo.setI(i);
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    i++;
                }
            });
        }
        Future<Integer> future = threadPool.submit(() -> {
            int sum = 0;
            for (int i = 1; i < 101; i++) {
                sum += i;
            }
            return sum;
        });
        System.out.println(future.get());
        threadPool.shutdown();
    }
}

class PoolDemo {
    private int i;

    public void setI(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}
