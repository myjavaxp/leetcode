package com.yibo.leetcode.solution01;

public class Solution0151 {
    public String reverseWords(String s) {
        s = s.trim();
        if (s.equals("")) {
            return s;
        }
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i > 0; i--) {
            String e = strings[i].trim();
            if (e.length() > 0) {
                sb.append(e).append(" ");
            }
        }
        sb.append(strings[0].trim());
        return sb.toString();
    }
}