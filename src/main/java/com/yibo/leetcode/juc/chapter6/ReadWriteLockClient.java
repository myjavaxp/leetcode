package com.yibo.leetcode.juc.chapter6;

public class ReadWriteLockClient {
    public static void main(String[] args) {
        final SharedData data = new SharedData(10);
        new ReadWorker(data).start();
        new ReadWorker(data).start();
        new ReadWorker(data).start();
        new ReadWorker(data).start();
        new ReadWorker(data).start();
        new ReadWorker(data).start();
        new ReadWorker(data).start();

        new WriteWorker(data, "dfdasfdsafdsafdsa").start();
        new WriteWorker(data, "FJDSAL;FJKLDSA;FJDKAS").start();
        new WriteWorker(data, "FJDSAL;FJKLDSA;4132432").start();
        new WriteWorker(data, "FJDSAL;43214321;FJDKAS").start();
    }
}