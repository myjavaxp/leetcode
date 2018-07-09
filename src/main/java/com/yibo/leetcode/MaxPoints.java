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
    public int maxPoints(Point[] points) {
        //先根据x轴排序
        List<Point> set = Arrays.asList(points);
        //得到所有子集合
        List<List<Point>> subSets = getSubSets(set, 1);
        int max=2;
        for (List<Point> myPoints : subSets) {
            if(myPoints.size()>2){
                for(int i=0;i<myPoints.size()-3;i++){
                    //i+2<myPoints.size()-1
                    if(!isLine(myPoints.get(i),myPoints.get(i+1),myPoints.get(i+2))){

                    }
                }
            }
        }
        return 1;
    }

    private boolean isLine(Point point, Point point1,Point point2) {
        return (point1.y - point2.y) * (point1.x - point.x) == (point1.x - point2.x) * (point1.y - point.y);
    }


    private static List<List<Point>> getSubSets(List<Point> set, int index) {
        List<List<Point>> allSubSets;
        if (set.size() == index) {
            allSubSets = new ArrayList<>();
            for (Point point : set) {
                allSubSets.add(Collections.singletonList(point)); //empty set
            }
        } else {
            allSubSets = getSubSets(set, index + 1);
            Point item = set.get(index);
            ArrayList<List<Point>> moreSubSets = new ArrayList<>();
            for (List<Point> s : allSubSets) {
                ArrayList<Point> newSubset = new ArrayList<>(s);
                newSubset.add(item);
                moreSubSets.add(newSubset);
            }
            allSubSets.addAll(moreSubSets);
        }
        return allSubSets;
    }


    public static void main(String[] args) {
        List<Point> s = new ArrayList<>();
        s.add(new Point(1, 2));
        s.add(new Point(2, 3));
        s.add(new Point(3, 4));
        List<List<Point>> allSubSets = getSubSets(s, 1);
        for (List<Point> set : allSubSets) {
            System.out.println(set);
        }

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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