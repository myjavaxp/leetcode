package com.yibo.leetcode.solution01;

public class Solution0080 {
    public int removeDuplicates(int[] nums) {
        int pre = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[pre]) {
                if (i - start > 1) {
                    nums[pre + 1] = nums[pre];
                    pre += 2;
                } else {
                    pre++;
                }
                //pre += (i - start > 1 ? 2 : 1);
                nums[pre] = nums[i];
                start = i;
            }
        }
        if (nums.length - start > 1) {
            nums[pre + 1] = nums[pre];
            return pre + 2;
        }
        return pre + 1;
    }
}
