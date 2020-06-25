package com.yibo.leetcode.solution01;

import java.util.HashSet;
import java.util.List;

public class Solution0139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[n]代表s[0->n]是否可以被拆分
        //dp[n]=or(s[i+1->n] in dict && dp[i]) i:[0,n-1]
        //s[0->n] in dict
        int n = s.length();
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n];
        for (int i = 0; i < n; i++) {
            dp[i] = set.contains(s.substring(0, i + 1));
            for (int j = 0; j < i; j++) {
                if (dp[i]) {
                    break;
                }
                dp[i] = dp[i] || (dp[j] && set.contains(s.substring(j + 1, i + 1)));
            }
        }
        return dp[n - 1];
    }
}
