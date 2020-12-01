package com.yibo.leetcode.solution01;

public class Solution1672 {
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int[] account : accounts) {
            int current = 0;
            for (int i : account) {
                current += i;
            }
            max = Math.max(max, current);
        }
        return max;
    }
}
