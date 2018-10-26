package com.yibo.leetcode.solution01;

/**
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 * <p>
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 * <p>
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 * <p>
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "112358"
 * 输出: true
 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 示例 2:
 * <p>
 * 输入: "199100199"
 * 输出: true
 * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 * 进阶:
 * 你如何处理一个溢出的过大的整数输入?
 */
public class Solution0306 {
    public boolean isAdditiveNumber(String num) {
        if (num == null) {
            return false;
        }
        long length = num.length();
        if (length < 3) {
            return false;
        }
        if (isThree(num)) {
            return true;
        }
        //i为第一个数字的长度
        for (int i = 1; 2 * i < length; i++) {
            System.out.println("待解决");
        }
        return false;
    }

    private boolean isThree(String three) {
        int length = three.length();
        if (length < 3) {
            return false;
        }
        int a = length / 3;
        for (int i = 1; i <= a; i++) {
            int b = (length - i) / 2;//第二个数字的长度
            if (three.charAt(0) != '0' && three.charAt(i) != '0' && three.charAt(i + b) != '0') {
                Long first = Long.valueOf(three.substring(0, i));
                Long second = Long.valueOf(three.substring(i, i + b));
                Long third = Long.valueOf(three.substring(i + b));
                if (third.equals(first + second)) {
                    return true;
                }
            }
        }
        return false;
    }
}
