package com.yibo.leetcode.solution01;

public class Solution0258 {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return addDigits(sum);
    }
}
