package com.yibo.leetcode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water-ii/description/
 */
public class TrapRainWater {
    public int trapRainWater(int[][] heightMap) {
        int x = heightMap.length;
        int y = heightMap[0].length;
        List<Pillar> list = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                list.add(new Pillar(i, j, heightMap[i][j]));
            }
        }
        return 0;
    }

    private int getValue(int x, int y, List<Pillar> list, Pillar pillar) {
        //如果在边缘则返回0
        if (pillar.getX() == 0 || pillar.getX() == x || pillar.getY() == 0 || pillar.getY() == y) {
            return 0;
        }
        //求能把该点包起来的【木桶】的最短板的高度，然后减去该点
        return 0;
    }

    private boolean isIn(List<Pillar> list, Pillar pillar) {
        //求出pillar的纵横坐标应该在list的最大最小值之间
        int maxX = 0;
        int minX = 0;
        int maxY = 0;
        int minY = 0;
        Optional<Pillar> p1 = list.stream().max(Comparator.comparingInt(Pillar::getX));
        Optional<Pillar> p2 = list.stream().min(Comparator.comparingInt(Pillar::getX));
        Optional<Pillar> p3 = list.stream().max(Comparator.comparingInt(Pillar::getY));
        Optional<Pillar> p4 = list.stream().min(Comparator.comparingInt(Pillar::getY));
        if (p1.isPresent()) {
            maxX = p1.get().getX();
        }
        if (p2.isPresent()) {
            minX = p2.get().getX();
        }
        if (p3.isPresent()) {
            maxY = p3.get().getY();
        }
        if (p4.isPresent()) {
            minY = p4.get().getY();
        }
        int x = pillar.getX();
        int y = pillar.getY();
        return x > minX && x < maxX && y > minY && y < maxY;
    }
    private boolean isCircle(){
        return false;
    }
}

class Pillar {
    private int x;
    private int y;
    private int value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pillar pillar = (Pillar) o;
        return x == pillar.x &&
                y == pillar.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }

    public Pillar() {
    }

    public Pillar(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pillar{" +
                "x=" + x +
                ", y=" + y +
                ", value=" + value +
                '}';
    }
}