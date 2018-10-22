package com.yibo.leetcode.solution01;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class Solution0204 {
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        if (n == 3) {
            return 1;
        }
        if (n == 4) {
            return 2;
        }
        if (n == 6) {
            return 3;
        }
        if (n == 8) {
            return 4;
        }
        if ((n - 1) % 2 == 0) {
            return countPrimes(n - 1);
        }
        //从9开始判定
        int sum = 4;
        for (int i = 9; i < n; i += 2) {
            if (isPrimes(i)) {
                sum++;
            }
        }
        return sum;
    }

    private boolean isPrimes(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
