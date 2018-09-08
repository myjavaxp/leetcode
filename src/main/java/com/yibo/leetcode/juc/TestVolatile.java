package com.yibo.leetcode.juc;

/**
 * 测试volatile关键字
 * 内存可见性
 * volatile不具备互斥性，不能保证变量的原子性
 *
 * @author Yibo
 */
public class TestVolatile {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        new Thread(threadDemo).start();
        while (true) {
            if (threadDemo.isFlag()) {
                System.out.println("-----");
                break;
            }
        }
    }
}

class ThreadDemo implements Runnable {
    private volatile boolean flag = false;

    boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag = " + isFlag());
    }
}