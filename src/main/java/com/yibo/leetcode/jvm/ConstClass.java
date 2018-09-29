package com.yibo.leetcode.jvm;

public class ConstClass {
    static {
        System.out.println(ConstClass.class.getSimpleName() + " init!");
    }

    public static final String HELLO = "hello";
}
