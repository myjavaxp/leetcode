package com.yibo.leetcode.solution01;

public class Solution1033 {
    public int[] numMovesStones(int a, int b, int c) {
        int[] res = new int[2];
        int min = Math.min(c, Math.min(a, b));
        int max = Math.max(c, Math.max(a, b));
        if (max - min > 2) {
            res[1] = max - min - 2;
            if (Math.abs(a - b) < 3 || Math.abs(b - c) < 3 || Math.abs(a - c) < 3) {
                res[0] = 1;
            } else {
                res[0] = 2;
            }
        }
        return res;
    }
}
