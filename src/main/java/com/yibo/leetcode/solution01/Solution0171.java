package com.yibo.leetcode.solution01;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例 1:
 * <p>
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: "ZY"
 * 输出: 701
 *
 * @author Yibo
 */
public class Solution0171 {
    public int titleToNumber(String s) {
        int length = s.length();
        int res = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int value = c - 'A' + 1;
            double d = Math.pow(26, length - 1 - i);
            res += d * value;
        }
        return res;
    }
}
