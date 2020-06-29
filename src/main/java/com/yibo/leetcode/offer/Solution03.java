package com.yibo.leetcode.offer;

public class Solution03 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp == i) {
                continue;
            }
            while (temp != i) {
                if (nums[temp] == temp) {
                    return temp;
                }
                temp = nums[temp];
                nums[temp] = nums[i];
            }
            nums[i] = temp;
        }
        return 0;
    }
}
