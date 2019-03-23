package com.yibo.leetcode.juc.chapter8;

public class AsyncFuture<V> implements Future<V> {
    private volatile boolean done = false;
    private V result;

    public void done(V result) {
        synchronized (this) {
            this.result = result;
            this.done = true;
            notifyAll();
        }
    }

    @Override
    public V get() throws InterruptedException {
        synchronized (this) {
            while (!done) {
                wait();
            }
        }
        return result;
    }
}
