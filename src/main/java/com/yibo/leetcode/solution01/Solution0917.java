package com.yibo.leetcode.solution01;

/**
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 * <p>
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 * <p>
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 */
public class Solution0917 {
    public String reverseOnlyLetters(String S) {
        char[] array = S.toCharArray();
        int l = 0;
        int r = S.length() - 1;
        while (r > l) {
            char left = array[l];
            char right = array[r];
            if (isLetter(left) && isLetter(right)) {
                array[l] = right;
                array[r] = left;
                l++;
                r--;
            } else if (isLetter(left)) {
                r--;
            } else if (isLetter(right)) {
                l++;
            } else {
                r--;
                l++;
            }
        }
        return new String(array);
    }

    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
