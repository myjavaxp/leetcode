package com.yibo.leetcode.solution01;

public class Solution0852 {
    public int peakIndexInMountainArray(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                return i;
            }
        }
        return A[A.length - 1];
    }
}
