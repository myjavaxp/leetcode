package com.yibo.leetcode.solution01;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 * 提示：
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 * 示例：
 * 给定下面的 5x5 矩阵:
 * 太平洋 ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 * *   *   *   *   * 大西洋
 * 返回:
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 *
 * @author yibo
 */
public class Solution0417 {
    private static final int[][] D = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int m, n;
    private boolean[][] visited;
    private boolean[][] pacific;
    private boolean[][] atlantic;

    public List<int[]> pacificAtlantic(int[][] matrix) {
        m = matrix.length;
        if (m < 1) {
            return new ArrayList<>();
        }
        n = matrix[0].length;
        pacific = new boolean[m][n];
        atlantic = new boolean[m][n];
        pacific[0][n - 1] = true;
        atlantic[0][n - 1] = true;
        pacific[m - 1][0] = true;
        atlantic[m - 1][0] = true;
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited = new boolean[m][n];
                visited[i][j] = true;
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i, j});
                } else if (searchPath(matrix, i, j, i, j)) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    private boolean searchPath(int[][] matrix, int x, int y, int nextX, int nextY) {
        int oldX = nextX;
        int oldY = nextY;

        for (int i = 0; i < 4; i++) {
            if (pacific[x][y] && atlantic[x][y]) {
                return true;
            }
            nextX = oldX + D[i][0];
            nextY = oldY + D[i][1];
            if (inPacific(nextX, nextY)) {
                pacific[x][y] = true;
                pacific[oldX][oldY] = true;
                if (atlantic[x][y]) {
                    return true;
                }
            } else if (inAtlantic(nextX, nextY)) {
                atlantic[x][y] = true;
                atlantic[oldX][oldY] = true;
                if (pacific[x][y]) {
                    return true;
                }
            } else if (!visited[nextX][nextY]) {//1，此时的点在矩阵内，2，下一个访问的点没有被访问过
                visited[nextX][nextY] = true;
                int nextVal = matrix[nextX][nextY];
                int cur = matrix[oldX][oldY];
                if (cur >= nextVal) {
                    if (pacific[nextX][nextY] && atlantic[nextX][nextY]) {
                        pacific[x][y] = true;
                        atlantic[x][y] = true;
                        return true;
                    } else {
                        searchPath(matrix, x, y, nextX, nextY);
                    }
                }
                visited[nextX][nextY] = false;
            }
        }
        return pacific[x][y] && atlantic[x][y];
    }

    private boolean inPacific(int x, int y) {
        return x < 0 || y < 0;
    }

    private boolean inAtlantic(int x, int y) {
        return x >= m || y >= n;
    }
}
