package com.yibo.leetcode.juc.chapter8;

import java.util.function.Consumer;

public class FutureService {
    public <V> Future<V> submit(final FutureTask<V> task) {
        AsyncFuture<V> future = new AsyncFuture<>();
        new Thread(() -> future.done(task.call())).start();
        return future;
    }

    public <V> Future<V> submit(final FutureTask<V> task, final Consumer<V> consumer) {
        AsyncFuture<V> future = new AsyncFuture<>();
        new Thread(() -> {
            V result = task.call();
            future.done(result);
            consumer.accept(result);
        }).start();
        return future;
    }
}