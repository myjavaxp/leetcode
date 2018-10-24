package com.yibo.leetcode.solution02;

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
        int[] result = new int[l];

        for (int i = 0; i < l; i++) {
            result[i] = 1;
        }
        //第一遍存的是i之前的每个数字的乘积
        int forwardNum = 1;
        for (int i = 0; i < l - 1; i++) {
            forwardNum *= nums[i];
            result[i + 1] = forwardNum;
        }
        //第二遍存i之后的乘积
        forwardNum = 1;

        for (int i = l - 1; i > 0; i--) {
            forwardNum *= nums[i];
            result[i - 1] *= forwardNum;
        }
        return result;
    }
}
