package com.yibo.leetcode.solution01;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * 类似问题376号
 *
 * @author yibo
 */
public class Solution0300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //memo[i]表示以nums[i]结尾的最长上升自序列的长度
        int[] memo = new int[nums.length];
        //算法复杂度o(n2)
        for (int i = 0; i < nums.length; i++) {
            memo[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }
        int res = 1;
        for (int i : memo) {
            res = Math.max(i, res);
        }
        return res;
    }
}
