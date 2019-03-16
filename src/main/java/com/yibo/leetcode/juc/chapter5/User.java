package com.yibo.leetcode.juc.chapter5;

public class User extends Thread {
    private final Gate gate;
    private final String myName;
    private final String myAddress;

    User(Gate gate, String myName, String myAddress) {
        this.gate = gate;
        this.myName = myName;
        this.myAddress = myAddress;
    }

    @Override
    public void run() {
        System.out.println(myName + " Begin");
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            this.gate.pass(myName, myAddress);
        }
    }
}