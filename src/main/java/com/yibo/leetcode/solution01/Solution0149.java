package com.yibo.leetcode.solution01;

public class Solution0149 {
    public int maxPoints(int[][] points) {
        //todo 解题
        return 0;
    }

    private boolean inLine(int[] p1, int[] p2, int[] p3) {
        return (p1[0] - p2[0]) * (p2[1] - p3[1]) == (p1[1] - p2[1]) * (p2[0] - p3[0]);
    }
}
