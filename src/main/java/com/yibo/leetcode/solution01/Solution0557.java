package com.yibo.leetcode.solution01;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class Solution0557 {
    public String reverseWords(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        String[] strings = s.split(" ");
        int l = strings.length;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < l - 1; i++) {
            res.append(new StringBuilder(strings[i]).reverse());
            res.append(' ');
        }
        return res.append(new StringBuilder(strings[l - 1]).reverse()).toString();
    }
}
