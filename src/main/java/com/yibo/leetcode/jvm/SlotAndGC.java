package com.yibo.leetcode.jvm;

public class SlotAndGC {
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[128 * 1024 * 1024];
        }
        //int a=0;
        System.gc();
        System.out.println("hello world");
    }
}
