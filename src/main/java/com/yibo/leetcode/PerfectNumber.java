package com.yibo.leetcode;

/**
 * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 * <p>
 * 给定一个 正整数 n， 如果他是完美数，返回 True，否则返回 False
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入: 28
 * 输出: True
 * 解释: 28 = 1 + 2 + 4 + 7 + 14
 * <p>
 * <p>
 * 注意:
 * <p>
 * 输入的数字 n 不会超过 100,000,000. (1e8)
 */
public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        int sum = 1;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i + num / i;
            }
        }
        if (num == 1) {
            return true;
        }
        return sum == num;
    }
}