package com.yibo.leetcode.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 等待唤醒机制
 * 虚假唤醒,使用while不用if
 */
public class ProducerAndConsumerSecond {
    public static void main(String[] args) {
        Clerk2 clerk = new Clerk2();
        Producer2 producer = new Producer2(clerk);
        Consumer2 consumer = new Consumer2(clerk);
        new Thread(producer, "生产者A").start();
        new Thread(consumer, "消费者A").start();
        new Thread(producer, "生产者B").start();
        new Thread(consumer, "消费者B").start();
    }
}

class Clerk2 {
    private int product;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void get() {
        lock.lock();
        try {
            while (product >= 1) {
                System.out.println("库存已满");
                condition.await();
            }
            product++;
            System.out.println(Thread.currentThread().getName() + ":" + product);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void sale() {
        lock.lock();
        try {
            while (product <= 0) {
                System.out.println("售罄");
                condition.await();
            }
            product--;
            System.out.println(Thread.currentThread().getName() + ":" + product);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class Producer2 implements Runnable {
    private Clerk2 clerk;

    Producer2(Clerk2 clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.get();
        }
    }
}

class Consumer2 implements Runnable {
    private Clerk2 clerk;

    Consumer2(Clerk2 clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            clerk.sale();
        }
    }
}
