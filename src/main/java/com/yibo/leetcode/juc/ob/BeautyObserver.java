package com.yibo.leetcode.juc.ob;

public class BeautyObserver implements Observer {
    private String className;

    BeautyObserver(String className) {
        this.className = className;
    }

    @Override
    public void update(String newState) {
        System.out.println("观察者观察到新状态: " + className + ": " + newState);
    }
}
