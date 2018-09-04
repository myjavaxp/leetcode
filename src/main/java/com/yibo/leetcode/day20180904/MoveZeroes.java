package com.yibo.leetcode.day20180904;

/**
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * @author Yibo
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    int temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = temp;
                }
                k++;
            }
        }
    }
}
