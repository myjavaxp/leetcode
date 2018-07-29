package com.yibo.leetcode;

import java.util.*;

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
 * https://leetcode-cn.com/problems/max-points-on-a-line/description/
 */
public class MaxPoints {
    public static int maxPoints(Point[] points) {
        Map<Point, Integer> map = new HashMap<>();
        //map key为点，value为点的个数
        for (Point point : points) {
            map.merge(point, 1, (a, b) -> a + b);
        }
        Set<Point> keySet = map.keySet();
        if (map.size() < 3) {
            int x = 0;
            for (Point point : keySet) {
                x += map.get(point);
            }
            return x;
        }
        //拿到不重复的点
        List<Point> pointSet = new ArrayList<>(keySet);
        //得到2个一组的子集合
        List<List<Point>> lists = new ArrayList<>();
        for (int i = 0; i < pointSet.size() - 1; i++) {
            for (int j = i + 1; j < pointSet.size(); j++) {
                lists.add(Arrays.asList(pointSet.get(i), pointSet.get(j)));
            }
        }
        int max = 0;
        //然后拿到2+1的各组的最大长度
        for (List<Point> myList : lists) {
            int listMax = map.get(myList.get(0)) + map.get(myList.get(1));
            for (Point point : pointSet) {
                if (!myList.contains(point) && isLine(myList.get(0), myList.get(1), point)) {
                    listMax += map.get(point);
                }
            }
            max = listMax > max ? listMax : max;
        }
        //最大长度中拿最大长度
        return max;
    }

    private static boolean isLine(Point point, Point point1, Point point2) {
        Long a = (long) (point.y - point1.y);
        Long b = (long) (point.x - point2.x);
        Long c = (long) (point.x - point1.x);
        Long d = (long) (point.y - point2.y);
        return (a * b) == (c * d);
    }

    public static void main(String[] args) {
        Point point = new Point(0, 0);
        Point point1 = new Point(1, 65536);
        Point point2 = new Point(65536, 0);
        System.out.println((point.y - point1.y) * (point.x - point2.x));
        System.out.println((point.x - point1.x) * (point.y - point2.y));
        System.out.println(isLine(point, point1, point2));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}