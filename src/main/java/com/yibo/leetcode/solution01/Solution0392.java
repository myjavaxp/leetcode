package com.yibo.leetcode.solution01;

public class Solution0392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int startS = 0;
        int startT = 0;
        while (startS < s.length() && startT < t.length()) {
            if (s.charAt(startS) == t.charAt(startT)) {
                startS++;
            }
            startT++;
        }
        return startS == s.length();
    }
}
