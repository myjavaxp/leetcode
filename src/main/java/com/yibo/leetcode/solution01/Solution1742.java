package com.yibo.leetcode.solution01;

public class Solution1742 {
    public int countBalls(int lowLimit, int highLimit) {
        int[] record = new int[46];
        int res = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            res = Math.max(res, ++record[getPosition(i)]);
        }
        return res;
    }

    private int getPosition(int i) {
        int res = 0;
        while (i != 0) {
            res += i % 10;
            i = i / 10;
        }
        return res;
    }
}
