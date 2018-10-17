package com.yibo.leetcode.solution01;

public class Solution0200 {
    private static final int[][] D = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int m;
    private int n;
    private boolean[][] visited;

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    private void dfs(char[][] grid, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + D[i][0];
            int newY = y + D[i][1];
            if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1') {
                dfs(grid, newX, newY);
            }
        }
    }

    public int numIslands(char[][] grid) {
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;
        int res = 0;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }
}
