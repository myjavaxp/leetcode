package com.yibo.leetcode.solution01;

/**
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 */
public class Solution0016 {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int t = nums[i] + nums[j] + nums[k];
                    int e = Math.abs(t - target);
                    if (min > e) {
                        min = e;
                        res = t;
                    }
                }
            }
        }
        return res;
    }
}
