package com.yibo.leetcode.solution01;

public class Solution0044 {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[] prev = new boolean[m + 1];
        for (int i = n; i >= 0; i--) {
            boolean[] dp = new boolean[m + 1];
            for (int j = m; j >= 0; j--) {
                if (i == n && j == m) {
                    dp[j] = true;
                } else if (j == m) {
                    dp[j] = false;
                } else if (i == n) {
                    dp[j] = p.charAt(j) == '*' && dp[j + 1];
                } else {
                    char a = s.charAt(i), b = p.charAt(j);
                    if (a == b || b == '?') {
                        dp[j] = prev[j + 1];
                    } else if (b == '*') {
                        dp[j] = prev[j] || dp[j + 1];
                    } else {
                        dp[j] = false;
                    }
                }
            }
            prev = dp;
        }
        return prev[0];
    }
}
