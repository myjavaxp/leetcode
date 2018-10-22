package com.yibo.leetcode.solution01;

/**
 * 动态规划
 *
 * @author Yibo
 */
public class Solution0198 {
    public int rob(int[] nums) {
        int l = nums.length;
        if (l == 0) {
            return 0;
        }

        //rob[i]表示考虑抢劫nums[i...n)所能获得的最大收益
        int[] rob = new int[l];
        rob[l - 1] = nums[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            for (int j = i; j < l; j++) {
                rob[i] = Math.max(rob[i], nums[j] + (j + 2 < l ? rob[j + 2] : 0));
            }
        }
        return rob[0];
    }
}
