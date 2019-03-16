package com.yibo.leetcode.juc.chapter6;

import java.util.Random;

public class WriteWorker extends Thread {
    private static final Random RANDOM = new Random(System.currentTimeMillis());
    private final SharedData data;
    private final String filler;
    private int index = 0;

    public WriteWorker(SharedData data, String filler) {
        this.data = data;
        this.filler = filler;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            char c = nextChar();
            data.write(c);
            try {
                Thread.sleep(RANDOM.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private char nextChar() {
        char c = filler.charAt(index);
        index++;
        if (index >= filler.length()) {
            index = 0;
        }
        return c;
    }
}