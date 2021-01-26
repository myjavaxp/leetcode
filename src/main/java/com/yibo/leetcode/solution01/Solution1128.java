package com.yibo.leetcode.solution01;

public class Solution1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] values = new int[89];
        for (int[] dominoe : dominoes) {
            values[getPosition(dominoe)]++;
        }
        int res = 0;
        for (Integer value : values) {
            res += getPair(value);
        }
        return res;
    }

    private int getPair(int a) {
        if (a < 2) {
            return 0;
        }
        return a * (a - 1) / 2;
    }

    private int getPosition(int[] a) {
        if (a[1] > a[0]) {
            return a[0] * 10 + a[1] - 11;
        }
        return a[1] * 10 + a[0] - 11;
    }
}
