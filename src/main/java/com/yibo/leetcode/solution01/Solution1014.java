package com.yibo.leetcode.solution01;

public class Solution1014 {
    public int maxScoreSightseeingPair(int[] A) {
        int res = A[0] + A[1] - 1;
        int start = 0;
        if (A[1] + 1 > A[0]) {
            start = 1;
        }
        for (int i = 2; i < A.length; i++) {
            int cur = A[i] + A[start] + start - i;
            if (cur > res) {
                res = cur;
            }
            if (A[i] + i > A[start] + start) {
                start = i;
            }
        }
        return res;
    }
}
