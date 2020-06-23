package com.yibo.leetcode.interview;

public class Solution1607 {
    public int maximum(int a, int b) {
        long dif = (long) a - (long) b;
        //System.out.println(dif);
        int k = (int) (dif >>> 63);
        //System.out.println(k);
        return a * (k ^ 1) + b * k;
    }
}
