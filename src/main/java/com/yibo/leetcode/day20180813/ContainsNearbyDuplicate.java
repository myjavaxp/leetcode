package com.yibo.leetcode.day20180813;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    if (j - i <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}