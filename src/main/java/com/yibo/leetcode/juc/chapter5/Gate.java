package com.yibo.leetcode.juc.chapter5;

import java.util.StringJoiner;

public class Gate {
    private int count = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    public synchronized void pass(String name, String address) {
        this.count++;
        this.name = name;
        this.address = address;
        verify();
    }

    private void verify() {
        if (this.name.charAt(0) != this.address.charAt(0)) {
            System.out.println("******BROKEN******" + toString());
        }
    }

    @Override
    public synchronized String toString() {
        return new StringJoiner(", ", Gate.class.getSimpleName() + "[", "]")
                .add("count=" + count)
                .add("name='" + name + "'")
                .add("address='" + address + "'")
                .toString();
    }
}