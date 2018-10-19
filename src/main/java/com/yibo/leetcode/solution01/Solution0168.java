package com.yibo.leetcode.solution01;

public class Solution0168 {
    public String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        do {
            int c = n % 26;
            char value;
            n = n / 26;
            if (c == 0) {
                value = 'Z';
                n = n - 1;
            } else {
                value = (char) ('A' + c - 1);
            }
            stringBuilder.insert(0, value);
        } while (n > 0);
        return stringBuilder.toString();
    }
}
