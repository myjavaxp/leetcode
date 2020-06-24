package com.yibo.leetcode.solution01;

import java.util.Arrays;

/**
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 */
public class Solution0016 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - res) > Math.abs(target - sum)) {
                    res = sum;
                }
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return res;
    }
}
