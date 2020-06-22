package com.yibo.leetcode.algorithm;

public class MergeSort {
    public static void sort(int[] nums) {
        if (nums == null) {
            return;
        }
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
    }

    private static void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int p = low, q = mid + 1;
        int[] temp = new int[high - low + 1];
        int index = 0;
        while (p <= mid && q <= high) {
            if (nums[p] >= nums[q]) {
                temp[index++] = nums[q++];
            } else {
                temp[index++] = nums[p++];
            }
        }
        while (p <= mid) {
            temp[index++] = nums[p++];
        }
        while (q <= high) {
            temp[index++] = nums[q++];
        }
        System.arraycopy(temp, 0, nums, low, high - low + 1);
    }
}
