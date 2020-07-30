package com.yibo.leetcode.juc;

/**
 * 等待唤醒机制
 * 虚假唤醒,使用while不用if
 */
public class ProducerAndConsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);
        new Thread(producer, "生产者1").start();
        new Thread(consumer, "消费者1").start();
        new Thread(producer, "生产者2").start();
        new Thread(consumer, "消费者2").start();
    }
}

class Clerk {
    private int product;

    public synchronized void get() {
        while (product > 0) {
            System.out.println("库存已满");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product++;
        System.out.println(Thread.currentThread().getName() + ":" + product);
        this.notifyAll();
    }

    synchronized void sale() {
        while (product < 1) {
            System.out.println("售罄");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product--;
        System.out.println(Thread.currentThread().getName() + ":" + product);
        this.notifyAll();
    }
}

class Producer implements Runnable {
    private final Clerk clerk;

    Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.get();
        }
    }
}

class Consumer implements Runnable {
    private final Clerk clerk;

    Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}