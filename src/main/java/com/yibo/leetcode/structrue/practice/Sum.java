package com.yibo.leetcode.structrue.practice;

public class Sum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(sum(arr));
    }

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    private static int sum(int[] arr, int n) {
        if (n == arr.length) {
            return 0;
        }
        return sum(arr, n + 1) + arr[n];
    }
}
