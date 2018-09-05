package com.yibo.leetcode.day20180905;

/**
 * https://leetcode-cn.com/problems/sort-colors/description/
 */
public class SortColors {
    public void sortColors(int[] nums) {
        //闭区间
        int zero = -1;
        int two = nums.length;
        for (int i = 0; i < two; ) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                two--;
                nums[i] = nums[two];
                nums[two] = 2;
            } else {
                assert nums[i] == 0;
                zero++;
                nums[i] = nums[zero];
                nums[zero] = 0;
                i++;
            }
        }
    }
}