package com.yibo.leetcode.solution01;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 案例:
 * s = "leetcode"
 * 返回 0.
 * s = "loveleetcode",
 * 返回 2.
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class Solution0387 {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] mem = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            mem[a - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (mem[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
