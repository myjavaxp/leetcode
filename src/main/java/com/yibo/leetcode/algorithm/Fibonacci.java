package com.yibo.leetcode.algorithm;

public class Fibonacci {
    public int methodA(int n) {
        if (n < 0) {
            return 0;
        }
        if (n < 2) {
            return 1;
        }
        return methodA(n - 1) + methodA(n - 2);
    }

    public int methodB(int n) {
        if (n < 0) {
            return 0;
        }
        if (n < 2) {
            return 1;
        }
        //记录每个位置的结果
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int methodC(int n) {
        if (n < 0) {
            return 0;
        }
        if (n < 2) {
            return 1;
        }
        int cur = 0;//当前
        int pre = 1;//前一个
        int prePre = 1;//上上个
        for (int i = 2; i <= n; i++) {
            cur = pre + prePre;
            prePre = pre;
            pre = cur;
        }
        return cur;
    }

    public int maxPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = matrix[i][j];
                } else if (i < m - 1 && j < n - 1) {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]) + matrix[i][j];
                } else if (i == m - 1) {
                    dp[i][j] = dp[i][j + 1] + matrix[i][j];
                } else {
                    dp[i][j] = dp[i + 1][j] + matrix[i][j];
                }
            }
        }

        return dp[0][0];
    }

}
