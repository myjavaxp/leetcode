package com.yibo.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * 示例 2:
 * <p>
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 */
public class MaxPoints {
    public int maxPoints(Point[] points) {
        //先根据x轴排序
        Arrays.sort(points, Comparator.comparingInt(o -> o.x));
        for (Point point : points) {

        }
        return 1;
    }

    private boolean isLine(Point[] points, Point point) {
        return (points[1].y - points[2].y) * (points[1].x - point.x) == (points[1].x - points[2].x) * (points[1].y - point.y);
    }
}

class Point {
    int x;
    int y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}