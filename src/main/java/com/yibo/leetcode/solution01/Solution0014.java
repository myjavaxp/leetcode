package com.yibo.leetcode.solution01;

public class Solution0014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder res = new StringBuilder();
        int l = strs[0].length();
        for (int i = 0; i < l; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < i + 1 || c != strs[j].charAt(i)) {
                    return res.toString();
                }
            }
            res.append(c);
        }
        return res.toString();
    }
}
