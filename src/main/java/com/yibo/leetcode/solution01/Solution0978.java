package com.yibo.leetcode.solution01;

/**
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 */
public class Solution0978 {
    public int maxTurbulenceSize(int[] A) {
        int max = 1;
        int flat = 0;
        int curIndex = 0;
        for (int i = 1; i < A.length; i++) {
            int e = A[i] - A[i - 1];
            if (e == 0) {
                curIndex = i;
            } else {
                if ((e > 0 && flat > 0) || (e < 0 && flat < 0)) {
                    curIndex = i - 1;
                } else {
                    max = Math.max(max, i - curIndex + 1);
                }
            }
            flat = e;
        }
        return max;
    }
}
