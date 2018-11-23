package com.yibo.leetcode.solution01;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 动态规划解法
 * 回文字符串的子串也是回文，比如P[i,j]（表示以i开始以j结束的子串）是回文字符串，那么P[i+1,j-1]也是回文字符串。
 * 这样最长回文子串就能分解成一系列子问题了。这样需要额外的空间O（N^2)，算法复杂度也是O(N^2)。
 * 首先定义状态方程和转移方程：
 * P[i,j]=false:表示子串[i,j]不是回文串。P[i,j]=true:表示子串[i,j]是回文串。
 * P[i,i]=true:当且仅当P[i+1,j-1] = true && (s[i]==s[j]）
 * 否则p[i,j] =false;
 */
public class Solution0005 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int start = 0;
        int maxLength = 0;
        boolean[][] p = new boolean[s.length()][s.length()];
        // 子串长度为1和为2的初始化
        for (int i = 0; i < len; i++) {
            p[i][i] = true;
            if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                p[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
        // 使用上述结果可以dp出子串长度为3~len -1的子串
        for (int k = 3; k <=len; k++) {
            for (int i = 0; i <= len - k; i++) {
                int j = i + k - 1; // 子串结束的位置
                if (p[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    p[i][j] = true;
                    maxLength = k;
                    start = i;
                }
            }
        }
        if (maxLength > 0) {
            return s.substring(start, start + maxLength);
        }
        return s.substring(0, 1);
    }
}