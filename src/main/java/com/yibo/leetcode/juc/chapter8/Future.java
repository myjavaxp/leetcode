package com.yibo.leetcode.juc.chapter8;

public interface Future<V> {
    V get() throws InterruptedException;
}
