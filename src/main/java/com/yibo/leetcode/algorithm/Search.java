package com.yibo.leetcode.algorithm;

public class Search {
    /**
     * 二分查找法
     *
     * @param arr    待查数组
     * @param n      右边界，闭区间
     * @param target 目标值
     * @param <T>    参数必须可比较
     * @return 索引位置，-1表示没有
     */
    public static <T extends Comparable<T>> int binarySearch(T[] arr, int n, T target) {
        n = n > arr.length ? arr.length : n;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int compare = arr[mid].compareTo(target);
            if (compare == 0) {
                return mid;
            }
            if (compare < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
