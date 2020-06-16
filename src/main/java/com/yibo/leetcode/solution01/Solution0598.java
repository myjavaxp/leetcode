package com.yibo.leetcode.solution01;

public class Solution0598 {
    public int maxCount(int m, int n, int[][] ops) {
        int row = m;
        int col = n;
        for (int[] op : ops) {
            row = Math.min(m, Math.min(op[0], row));
            col = Math.min(n, Math.min(op[1], col));
        }
        return row * col;
    }
}
