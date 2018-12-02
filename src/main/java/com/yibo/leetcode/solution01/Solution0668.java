package com.yibo.leetcode.solution01;

public class Solution0668 {
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int count = 0, j = n;
            for (int i = 1; i <= m; i++) {
                //遍历每一行
                //看一行中有几个元素小于当前值
                while (j >= 1 && i * j > mid) {
                    j--;
                }
                //求和
                count += j;
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
