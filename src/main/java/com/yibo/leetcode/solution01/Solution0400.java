package com.yibo.leetcode.solution01;

/**
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 * 注意:
 * n 是正数且在32为整形范围内 ( n < 231)。
 * 示例 1:
 * 输入:
 * 3
 * 输出:
 * 3
 * 示例 2:
 * 输入:
 * 11
 * 输出:
 * 0
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 */
public class Solution0400 {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        long sum = 9;
        int i = 1;//表示几位数
        long prevSum = sum;
        while (sum <= n) {
            prevSum = sum;
            i++;
            sum += 9 * i * Math.pow(10, i - 1);
        }
        //此时n是落在i这个区间
        long index = n - prevSum;//找的是第index个数字
        long a = index / i;
        long b = index % i;
        long start = (long) Math.pow(10, i - 1);
        long res = start + a - 1;
        if (b == 0) {
            return (int) (res % 10);
        } else {
            res++;
            char c = String.valueOf(res).charAt((int) (b - 1));
            return c - '0';
        }
    }
}