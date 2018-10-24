package com.yibo.leetcode.solution02;

public class Solution0832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int x = A.length, y = A[0].length;
        int[][] B = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                B[i][j] = A[i][y - 1 - j] ^ 1;
            }
        }
        return B;
    }
}
