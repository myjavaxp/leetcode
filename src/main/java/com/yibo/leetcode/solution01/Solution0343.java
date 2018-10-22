package com.yibo.leetcode.solution01;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class Solution0343 {
    public int integerBreak(int n) {
        if (n == 1) {
            return 1;
        }
        int[] max = new int[n + 1];
        max[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                max[i] = Math.max(Math.max(max[i], j * (i - j)), j * max[i - j]);
            }
        }
        return max[n];
    }
}
