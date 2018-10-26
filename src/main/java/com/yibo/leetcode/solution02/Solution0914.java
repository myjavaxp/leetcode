package com.yibo.leetcode.solution02;

public class Solution0914 {
    public boolean hasGroupsSizeX(int[] deck) {
        int res = 0;
        int[] times = new int[10000];
        for (int i : deck)
            times[i]++;
        for (int i : times)
            if (i != 0)
                res = gcd(i, res);
        return res > 1;
    }

    private int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}
