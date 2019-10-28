package com.yibo.leetcode.solution01;

public class Solution0055 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return true;
        }
        if (nums[0] == 0) {//len>=2
            return false;
        }
        if (len == 2) {//nums[0]!=0
            return true;
        }
        boolean flag;
        for (int i = 2; ; ) {//len>=3
            flag = false;
            for (int k = i - 1; k >= 0; k--) {
                if (i - k <= nums[k]) {
                    i = (nums[k] + k + 1);
                    if (i > len - 1) {
                        return true;
                    }
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
    }
}
