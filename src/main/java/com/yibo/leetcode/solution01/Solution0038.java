package com.yibo.leetcode.solution01;

public class Solution0038 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        char cur = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == cur) {
                count++;
            } else {
                sb.append(count).append(cur);
                cur = c;
                count = 1;
            }
        }
        sb.append(count).append(cur);
        return sb.toString();
    }
}
