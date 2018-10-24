package com.yibo.leetcode.solution01;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 * 类似问题322、377
 */
public class Solution0416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int n = nums.length;
        int c = sum / 2;
        boolean[] memo = new boolean[c + 1];
        for (int i = 0; i <= c; i++) {
            memo[i] = (nums[0] == i);
        }
        for (int i = 1; i < n; i++) {
            for (int j = c; j >= nums[i]; j--) {
                memo[j] = memo[j] || memo[j - nums[i]];
            }
        }
        return memo[c];
    }
}
