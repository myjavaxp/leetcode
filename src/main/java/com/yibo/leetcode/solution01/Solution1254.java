package com.yibo.leetcode.solution01;

public class Solution1254 {
    private static final int[][] DIRECTION = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int col;
    private int row;
    private boolean[][] visited;

    public int closedIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        visited = new boolean[row][col];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    if (internal(i, j) && dfs(grid, i, j)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private boolean dfs(int[][] grid, int x, int y) {
        boolean flag = true;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int x1 = x + DIRECTION[i][0];
            int y1 = y + DIRECTION[i][1];
            if (inArea(x1, y1) && !visited[x1][y1] && grid[x1][y1] == 0) {
                if (!internal(x1, y1)) {
                    flag = false;
                }
                if (!dfs(grid, x1, y1)) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }

    private boolean internal(int x, int y) {
        return x > 0 && y > 0 && x < row - 1 && y < col - 1;
    }
}
