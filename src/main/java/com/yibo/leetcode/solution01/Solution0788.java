package com.yibo.leetcode.solution01;

public class Solution0788 {
    public int rotatedDigits(int N) {
        int[] dictionary = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (isGood(i, dictionary)) {
                res++;
            }
        }
        return res;
    }

    private boolean isGood(int n, int[] dictionary) {
        boolean res = false;
        while (n > 0) {
            int no = dictionary[n % 10];
            if (no == -1) {
                return false;
            }
            if (no == 1) {
                res = true;
            }
            n = n / 10;
        }
        return res;
    }
}
