package com.yibo.leetcode.solution01;

import java.util.Arrays;

/**
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 */
public class Solution0164 {
    public int maximumGap(int[] nums) {
        //todo 桶排序
        //todo 基数排序
        if (nums == null || nums.length < 2) {
            return 0;
        }
        if (nums.length == 2) {
            return Math.abs(nums[0] - nums[1]);
        }
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Integer.max(max, nums[i + 1] - nums[i]);
        }
        return max;
    }
}
