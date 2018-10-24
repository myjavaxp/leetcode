package com.yibo.leetcode.solution01;

public class Solution0344 {
    public String reverseString(String s) {
        if (s == null) {
            return null;
        }
        int l = s.length();
        char[] c = s.toCharArray();
        for (int i = 0; i < l / 2; i++) {
            char a = c[i];
            c[i] = c[l - i - 1];
            c[l - i - 1] = a;
        }
        return new String(c);
    }
}
