package com.yibo.leetcode.solution01;

public class Solution0053 {
    public int maxSubArray(int[] nums) {
        int max = nums[0], cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur += nums[i];
            if (nums[i] > cur) {
                cur = nums[i];
                max = Math.max(max, cur);
            } else {
                if (nums[i] > 0) {
                    max = Math.max(max, cur);
                }
            }
        }
        return max;
    }
}
