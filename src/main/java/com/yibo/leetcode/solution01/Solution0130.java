package com.yibo.leetcode.solution01;

public class Solution0130 {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0 && j != 0 && i != m - 1 && j != n - 1 && !visited[i][j]) {
                    search(board, visited, i, j);
                }
                visited[i][j] = true;
            }
        }
    }

    public char search(char[][] board, boolean[][] visited, int i, int j) {
        if (visited[i][j]) {
            return board[i][j];
        }
        if (board[i][j] == 'X') {
            visited[i][j] = true;
            return board[i][j];
        }
        char up = search(board, visited, i - 1, j);
        char down = search(board, visited, i + 1, j);
        char left = search(board, visited, i, j - 1);
        char right = search(board, visited, i, j + 1);
        return 'A';
    }
}
