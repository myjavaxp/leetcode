package com.yibo.leetcode.juc.chapter6;

import java.util.Arrays;

public class ReadWorker extends Thread {
    private final SharedData data;

    public ReadWorker(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            char[] chars = data.read();
            System.out.println(Thread.currentThread().getName() + " reads " + Arrays.toString(chars));
        }
    }
}
