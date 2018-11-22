package com.yibo.leetcode.solution02;

public class Solution0387 {
    public int firstUniqChar(String s) {
        int res = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = s.indexOf(ch);
            if (index != -1 && index == s.lastIndexOf(ch)) {
                res = res == -1 ? index : Math.min(res, index);
            }
        }
        return res;
    }
}