package com.yibo.leetcode.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AlternateDemo {
    public static void main(String[] args) {
        Alternate alternate = new Alternate();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                alternate.loopA(i);
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                alternate.loopB(i);
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                alternate.loopC(i);
            }
        }, "C").start();
    }
}

class Alternate {
    private int number = 1;//当前执行线程的标记
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    /**
     * 循环打印
     *
     * @param totalLoop 循环第几轮
     */
    void loopA(int totalLoop) {
        lock.lock();
        try {
            while (number != 1) {
                condition1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }
            number = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void loopB(int totalLoop) {
        lock.lock();
        try {
            while (number != 2) {
                condition2.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }
            number = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void loopC(int totalLoop) {
        lock.lock();
        try {
            while (number != 3) {
                condition3.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }
            number = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}