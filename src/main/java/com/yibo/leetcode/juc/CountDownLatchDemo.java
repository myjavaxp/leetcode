package com.yibo.leetcode.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int count = 5;
        final CountDownLatch latch = new CountDownLatch(count);
        LatchDemo latchDemo = new LatchDemo(latch);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            new Thread(latchDemo).start();
        }
        latch.await();
        long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start) + "毫秒");
    }

}

class LatchDemo implements Runnable {
    private CountDownLatch countDownLatch;

    LatchDemo(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 50000; i++) {
                    if (i % 2 == 0) {
                        System.out.println(i);
                    }
                }
            } finally {
                countDownLatch.countDown();
            }
        }
    }
}
