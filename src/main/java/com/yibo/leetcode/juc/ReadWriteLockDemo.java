package com.yibo.leetcode.juc;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 写写/读写 需要互斥
 * 读读不需要互斥
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        ReadWrite readWrite = new ReadWrite();
        new Thread(() -> readWrite.set(new Random().nextInt(100)), "Write:").start();
        for (int i = 0; i < 100; i++) {
            new Thread(readWrite::get).start();
        }
    }
}

class ReadWrite {
    private int number;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    //读操作
    void get() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t" + number);
        } finally {
            lock.readLock().unlock();
        }
    }

    void set(int number) {
        lock.writeLock().lock();
        try {
            this.number = number;
            System.out.println(Thread.currentThread().getName());
        } finally {
            lock.writeLock().unlock();
        }
    }
}
