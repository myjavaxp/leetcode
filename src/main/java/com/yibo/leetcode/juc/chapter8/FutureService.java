package com.yibo.leetcode.juc.chapter8;

public class FutureService {
    public <V> Future<V> submit(final FutureTask<V> task) {
        AsyncFuture<V> future = new AsyncFuture<>();
        new Thread(() -> future.done(task.call())).start();
        return future;
    }
}
