package com.yibo.leetcode.history;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        for (int i = s.length(); i > 0; i--) {//i为子串长度
            List<String> subString = getSubString(s, i);
            for (String s1 : subString) {
                if (isPalindrome(s1)) {
                    return s1;
                }
            }
        }
        return null;
    }

    private boolean isPalindrome(String string) {
        char[] chars = string.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != chars[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    private List<String> getSubString(String s, int n) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i <= s.length() - n; i++) {
            list.add(s.substring(i, i + n));
        }
        return list;
    }
}