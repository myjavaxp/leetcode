package com.yibo.leetcode.solution01;

public class Solution0389 {
    public char findTheDifference(String s, String t) {
        int[] records = new int[26];
        for (int i = 0; i < s.length(); i++) {
            records[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--records[t.charAt(i) - 'a'] < 0) {
                return t.charAt(i);
            }
        }
        return ' ';
    }
}
