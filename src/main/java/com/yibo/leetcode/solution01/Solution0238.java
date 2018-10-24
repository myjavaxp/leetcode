package com.yibo.leetcode.solution01;

/**
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class Solution0238 {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] res = new int[l];
        res[0] = nums[1];
        res[1] = nums[0];
        for (int i = 2; i < l; i++) {
            res[i] = res[0] * nums[0];
            for (int j = 0; j < i; j++) {
                res[j] = res[j] * nums[i];
            }
        }
        return res;
    }
}
