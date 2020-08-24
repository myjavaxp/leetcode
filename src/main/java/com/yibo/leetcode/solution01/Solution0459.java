package com.yibo.leetcode.solution01;

public class Solution0459 {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int length = s.length();
        int smallLength = length / 2;
        while (smallLength > 0) {
            if (length % smallLength == 0) {
                int n = length / smallLength;
                boolean res = true;
                for (int i = 0; i < smallLength; i++) {
                    char standard = s.charAt(i);
                    for (int j = 1; j < n; j++) {
                        if (s.charAt(i + j * smallLength) != standard) {
                            res = false;
                            break;
                        }
                    }
                    if (!res) {
                        break;
                    }
                }
                if (res) {
                    return true;
                }
            }
            smallLength--;
        }
        return false;
    }
}
