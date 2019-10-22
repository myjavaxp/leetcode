package com.yibo.leetcode.juc.ob;

public class ObserverDemo {
    public static void main(String[] args) {
        NikeSubject subject = new NikeSubject();
        Observer observer1 = new BeautyObserver(subject.getClass().getName());
        //System.out.println(observer1.getClass().getName());
        //Observer observer2 = new BeautyObserver();
        subject.attach(observer1);
        //subject.attach(observer2);
        subject.runTestCase();
    }
}
