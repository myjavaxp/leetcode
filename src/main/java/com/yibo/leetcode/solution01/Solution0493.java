package com.yibo.leetcode.solution01;

public class Solution0493 {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }

    private int mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return 0;
        }
        int mid = lo + (hi - lo) / 2;
        int res = 0;
        res += mergeSort(nums, lo, mid);
        res += mergeSort(nums, mid + 1, hi);
        res += merge(nums, lo, mid, hi);
        return res;
    }

    private int merge(int[] nums, int lo, int mid, int hi) {
        int count = 0;
        int[] a = new int[hi - lo + 1];
        int p = lo, q = mid + 1;
        while (p <= mid && q <= hi) {
            if ((long) nums[p] - (long) nums[q] > (long) nums[q]) {
                count += mid - p + 1;
                q++;
            } else {
                p++;
            }
        }
        p = lo;
        q = mid + 1;
        int index = 0;
        while (p <= mid && q <= hi) {
            if (nums[p] > nums[q]) {
                a[index++] = nums[q++];
            } else {
                a[index++] = nums[p++];
            }
        }
        while (p <= mid) {
            a[index++] = nums[p++];
        }
        while (q <= hi) {
            a[index++] = nums[q++];
        }
        System.arraycopy(a, 0, nums, lo, hi - lo + 1);
        return count;
    }
}
