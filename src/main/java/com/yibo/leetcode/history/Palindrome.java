package com.yibo.leetcode.history;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class Palindrome {
    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : chars) {
            list.add(c);
        }
        Map<Character, List<Character>> collect = list.stream().collect(Collectors.groupingBy(Character::charValue));
        boolean flag = true;
        int size = 0;
        Set<Character> characters = collect.keySet();
        for (Character c : characters) {
            int length = collect.get(c).size();
            if (length % 2 != 0) {
                if (flag) {
                    size += length;
                    flag = false;
                } else {
                    size += length - 1;
                }
            } else {
                size += length;
            }
        }
        return size;
    }
}