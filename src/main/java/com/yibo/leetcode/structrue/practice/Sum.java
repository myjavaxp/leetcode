package com.yibo.leetcode.structrue.practice;

public class Sum {
    public int sum(int[] arr) {
        return sum(arr, 0);
    }

    private int sum(int[] arr, int n) {
        if (n == arr.length) {
            return 0;
        }
        return sum(arr, n + 1) + arr[n];
    }
}
