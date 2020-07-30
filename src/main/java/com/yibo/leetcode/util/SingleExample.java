package com.yibo.leetcode.util;

public class SingleExample {
    private static final SingleExample ourInstance = new SingleExample();

    public static SingleExample getInstance() {
        return ourInstance;
    }

    private SingleExample() {
    }
}
