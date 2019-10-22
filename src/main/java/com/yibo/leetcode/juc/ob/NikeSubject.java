package com.yibo.leetcode.juc.ob;

import java.util.concurrent.TimeUnit;

public class NikeSubject extends Subject {
    private String state;

    public String getState() {
        return state;
    }

    private void change(String newState) {
        state = newState;
        //System.out.println("NikeSubject state: " + newState);

        //状态发生改变，通知观察者
        notifyEveryOne(newState);
    }

    void runTestCase() {
        this.change("Running");

        try {
            TimeUnit.SECONDS.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.change("Done");
    }
}
