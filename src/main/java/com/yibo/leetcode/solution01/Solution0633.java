package com.yibo.leetcode.solution01;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * <p>
 * 示例1:
 * <p>
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 * <p>
 * 示例2:
 * <p>
 * 输入: 3
 * 输出: False
 */
public class Solution0633 {
    public boolean judgeSquareSum(int c) {
        int sqrt = (int) Math.sqrt(c);
        int temp;
        int j = sqrt;
        for (int i = 0; i <= sqrt; ) {
            temp = i * i + j * j;
            if (temp < c) {
                i++;
            } else if (temp > c) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}
