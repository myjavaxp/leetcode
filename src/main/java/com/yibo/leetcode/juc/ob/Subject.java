package com.yibo.leetcode.juc.ob;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Subject {
    //保存注册的观察者对象
    private List<Observer> observerList = new CopyOnWriteArrayList<>();

    //注册观察者对象
    public void attach(Observer observer) {
        observerList.add(observer);
        System.out.println("注册观察者");
    }

    //注销观察者对象
    public void detach(Observer observer) {
        observerList.remove(observer);
        System.out.println("注销观察者");
    }

    //通知所有注册的观察者对象
    void notifyEveryOne(String newState) {
        for (Observer observer : observerList) {
            observer.update(newState);
        }
    }
}
