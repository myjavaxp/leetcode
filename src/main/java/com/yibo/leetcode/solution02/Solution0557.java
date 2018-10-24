package com.yibo.leetcode.solution02;

public class Solution0557 {
    public String reverseWords(String s) {
        char[] res = s.toCharArray();
        int start = 0, end;
        while (start < res.length) {
            end = s.indexOf(' ', start);
            if (end == -1) {
                reverse(res, start, res.length - 1);
                break;
            }
            reverse(res, start, end - 1);
            start = end + 1;
        }
        return new String(res);
    }

    private void reverse(char[] w, int l, int r) {
        while (l < r) {
            char t = w[l];
            w[l] = w[r];
            w[r] = t;
            l++;
            r--;
        }
    }
}
