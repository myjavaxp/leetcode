package com.yibo.leetcode.juc;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicDemo {
    public static void main(String[] args) {
        AtomicDemo atomicDemo = new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(atomicDemo).start();
        }
    }
}

/**
 * volatile也无法解决，因为有读改写三种操作
 * 需要使用原子变量
 * cas算法保证原子性，volatile保证内存可见性
 */
class AtomicDemo implements Runnable {
    private AtomicInteger serialNumber = new AtomicInteger();

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " : " + getSerialNumber());
    }

    private int getSerialNumber() {
        return serialNumber.getAndIncrement();
    }
}
