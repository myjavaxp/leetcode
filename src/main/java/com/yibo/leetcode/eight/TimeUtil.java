package com.yibo.leetcode.eight;

public class TimeUtil {
    public static long calTime(Action action) {
        long start = System.nanoTime();
        action.run();
        return System.nanoTime() - start;
    }
}