package com.yibo.leetcode.solution01;

public class Solution0048 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n < 2) {
            return;
        }
        int down = n - 1;
        int up = 0;
        while (down - up > 0) {
            myRotate(matrix, up, down);
            down--;
            up++;
        }
    }

    /**
     * up up down down
     *
     * @param matrix 矩阵
     * @param up     左上
     * @param down   右下
     */
    private void myRotate(int[][] matrix, int up, int down) {
        for (int i = 0; i < down - up; i++) {
            int a = matrix[up][up + i];//up up
            int b = matrix[up + i][down];//up down
            int c = matrix[down][down - i];//down down
            int d = matrix[down - i][up];//down up
            matrix[up + i][down] = a;
            matrix[down][down - i] = b;
            matrix[down - i][up] = c;
            matrix[up][up + i] = d;
        }
    }
}
