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
        if (n <= 1) {
            return 0;
        }
        // 默认所有的元素值都会设置为false，boolean初始值为false
        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;
        for (int i = 2; i * i < n; i++) {
            if (!notPrime[i]) {
                // 如果i是一个质数， 将i的倍数设置为非质数,
                //j += i相当于i的3倍，4倍……
                for (int j = 2 * i; j < n; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        // 统计质数的个数
        int result = 0;
        for (boolean notPri : notPrime) {
            if (!notPri) {
                result++;
            }
        }
        return result;
    }
}
