package com.yibo.leetcode.solution01;

public class Solution0063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;//m行
        int n = obstacleGrid[0].length;//n列
        //dp[i][j]=dp[i][j+1]+dp[i+1][j]
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = (i == m - 1 && j == n - 1) ? 1 : ((j + 1 >= n ? 0 : dp[i][j + 1]) + (i + 1 >= m ? 0 : dp[i + 1][j]));
                }
            }
        }
        return dp[0][0];
    }
}
