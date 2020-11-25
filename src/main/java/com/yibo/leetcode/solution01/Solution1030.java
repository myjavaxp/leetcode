package com.yibo.leetcode.solution01;

import java.util.Arrays;

public class Solution1030 {
    public static void main(String[] args) {
        Arrays.stream(new Solution1030().allCellsDistOrder(2, 3, 1, 2)).forEach(e -> System.out.println(Arrays.toString(e)));
    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][2];
        int index = 1;
        result[0] = new int[]{r0, c0};
        for (int i = 1; i < R + C - 1; i++) {
            //System.out.println(i);
            //距离为寻找距离为i的坐标
            for (int j = -i; j <= 0; j++) {
                int x = r0 + j, y = c0 + j + i;
                if (inMatrix(R, C, x, y)) {
                    result[index] = new int[]{x, y};
                    //System.out.println("x=" + x + "  y=" + y);
                    index++;
                }
                y = c0 - j - i;
                if (i + j != 0 && inMatrix(R, C, x, y)) {
                    result[index] = new int[]{x, y};
                    //System.out.println("x=" + x + "  y=" + y);
                    index++;
                }
            }
            for (int j = 1; j <= i; j++) {
                int x = r0 + j, y = c0 - j + i;
                if (inMatrix(R, C, x, y)) {
                    result[index] = new int[]{x, y};
                    //System.out.println("x=" + x + "  y=" + y);
                    index++;
                }
                y = c0 + j - i;
                if (i - j != 0 && inMatrix(R, C, x, y)) {
                    result[index] = new int[]{x, y};
                    //System.out.println("x=" + x + "  y=" + y);
                    index++;
                }
            }
        }
        return result;
    }

    private boolean inMatrix(int R, int C, int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
