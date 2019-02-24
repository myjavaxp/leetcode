package com.yibo.test;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class TestJuc {
    @Test
    public void test01() {
        int cycle = 10000;
        int client = 1000;
        AtomicInteger integer = new AtomicInteger(0);
        final CountDownLatch countDownLatch = new CountDownLatch(cycle);
        final Semaphore semaphore = new Semaphore(client);
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < cycle; i++) {
            pool.execute(() -> {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                integer.getAndIncrement();
                semaphore.release();
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();
        System.out.println(integer.get());
    }
}
