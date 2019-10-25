package com.yibo.leetcode.solution01;

public class Solution0058 {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        int n = s.length();
        char[] arr = s.toCharArray();
        int start = -1;
        int end = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] != ' ' && start == -1) {
                start = i;
            }
            if (arr[i] == ' ' && start != -1) {
                end = i;
                break;
            }
        }
        if (start == -1) {
            return 0;
        }
        return start - end;
    }
}
