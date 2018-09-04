package com.yibo.leetcode.util;

import java.util.Random;

public class ArrayUtil {
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert (n > 0 && rangeL <= rangeR);
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rangeL + random.nextInt(rangeR - rangeL);
        }
        return arr;
    }

    public static Integer[] generateOrderedArray(int n) {
        assert (n > 0);
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }
}
