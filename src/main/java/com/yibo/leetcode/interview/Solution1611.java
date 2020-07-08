package com.yibo.leetcode.interview;

public class Solution1611 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        int e = longer - shorter;
        if (e == 0) {
            return new int[]{shorter * k};
        }
        int[] res = new int[k + 1];
        res[0] = k * shorter;
        for (int i = 1; i <= k; i++) {
            res[i] = res[i - 1] + e;
        }
        return res;
    }
}
