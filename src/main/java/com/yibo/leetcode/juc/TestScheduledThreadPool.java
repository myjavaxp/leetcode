package com.yibo.leetcode.juc;

import java.util.Random;
import java.util.concurrent.*;

public class TestScheduledThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
        ScheduledFuture<Integer> schedule = threadPool.schedule(() -> {
            int i = new Random().nextInt(100);
            System.out.println(Thread.currentThread().getName() + ":" + i);
            return i;
        }, 1L, TimeUnit.SECONDS);
        System.out.println(schedule.get());
        threadPool.shutdown();
    }
}
