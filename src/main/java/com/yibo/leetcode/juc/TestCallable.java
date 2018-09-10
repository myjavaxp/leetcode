package com.yibo.leetcode.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TreadDemo treadDemo = new TreadDemo();
        FutureTask<Integer> futureTask = new FutureTask<>(treadDemo);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}

class TreadDemo implements Callable<Integer> {

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
        }
        return sum;
    }
}