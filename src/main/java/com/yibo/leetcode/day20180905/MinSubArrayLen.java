package com.yibo.leetcode.day20180905;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例:
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3] 输出: 2 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。 进阶:
 * <p>
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/description/
 *
 * @author Yibo
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = -1, sum = 0, res = nums.length + 1;// nums[l...r]为我们的滑动窗口
        while (l < nums.length) {
            if (r < nums.length - 1 && sum < s) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }
            if (sum >= s) {
                int length = r - l + 1;
                res = res < length ? res : length;
            }
        }
        if (res == nums.length + 1) {
            return 0;
        }
        return res;
    }
}
