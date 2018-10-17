package com.yibo.leetcode.solution01;

/**
 * @author yibo
 */
public class Solution0079 {
    private static final int[][] D = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int m;
    private int n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board.length < 1) {
            return false;
        }
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 递归函数
     * 从board[indexX][indexY]开始，寻找word[index,word.length())
     *
     * @param board  查找的矩阵
     * @param word   目标单词
     * @param index  目标单词的位
     * @param indexX x轴
     * @param indexY y轴
     * @return 是否存在
     */
    private boolean searchWord(char[][] board, String word, int index, int indexX, int indexY) {
        if (index == word.length() - 1) {
            return board[indexX][indexY] == word.charAt(index);
        }
        if (board[indexX][indexY] == word.charAt(index)) {
            visited[indexX][indexY] = true;
            for (int i = 0; i < 4; i++) {
                int newX = indexX + D[i][0];
                int newY = indexY + D[i][1];
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    if (searchWord(board, word, index + 1, newX, newY)) {
                        return true;
                    }
                }
            }
            visited[indexX][indexY] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
