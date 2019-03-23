package com.yibo.leetcode.juc.chapter8;

import java.util.concurrent.TimeUnit;

public class SyncInvoker {
    public static void main(String[] args) {
        FutureService service = new FutureService();
        service.submit(SyncInvoker::get, System.out::println);
        System.out.println("做一些其他事情");
        System.out.println("完成Future");
    }

    private static String get() {
        try {
            TimeUnit.SECONDS.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "FINISH";
    }
}
