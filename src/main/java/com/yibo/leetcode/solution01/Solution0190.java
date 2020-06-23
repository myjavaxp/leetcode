package com.yibo.leetcode.solution01;

public class Solution0190 {
    public int reverseBits(int n) {
        //TODO: 有空需要再看一下各种位运算
        int a = 0;
        for (int i = 0; i <= 31; i++) {
            a = a + ((1 & (n >> i)) << (31 - i));
        }
        return a;
    }
}
