package com.yibo.leetcode.solution01;

public class Solution0292 {
    public boolean canWinNim(int n) {
        if (n == 0) {
            return true;
        }
        return n % 4 != 0;
    }
}