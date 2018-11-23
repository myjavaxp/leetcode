package com.yibo.leetcode.solution01;

public class Solution0008 {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        int length = str.length();
        if (length == 0) {
            return 0;
        }
        char first = str.charAt(0);
        if (first != '-' && first != '+' && (first > '9' || first < '0')) {
            return 0;
        }
        if (first == '-' || first == '+') {
            if (length == 1) {
                return 0;
            }
            if (str.charAt(1) > '9' || str.charAt(1) < '0') {
                return 0;
            }
            int index = 0;
            for (int i = 2; i < str.length(); i++) {
                if (str.charAt(i) > '9' || str.charAt(i) < '0') {
                    index = i;
                    break;
                }
            }
            if (index == 0) {
                return format(str);
            }
            return format(str.substring(0, index));
        } else {
            int index = 0;
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) > '9' || str.charAt(i) < '0') {
                    index = i;
                    break;
                }
            }
            if (index == 0) {
                return format(str);
            }
            return format(str.substring(0, index));
        }
    }

    private int format(String str) {
        try {
            return Integer.valueOf(str);
        } catch (Exception e) {
            if (str.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }
}