package com.yibo.leetcode.util;

public class SingleExample {
    private static SingleExample ourInstance = new SingleExample();

    public static SingleExample getInstance() {
        return ourInstance;
    }

    private SingleExample() {
    }
}
