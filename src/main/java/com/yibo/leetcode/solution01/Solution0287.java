package com.yibo.leetcode.solution01;

public class Solution0287 {
    //todo: 待解决问题
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int flag = nums[i];
            int temp = nums[i];
            if (temp == i) {
                continue;
            }
            while (temp != flag) {
                temp = nums[temp];
            }
        }
        return 0;
    }
}
