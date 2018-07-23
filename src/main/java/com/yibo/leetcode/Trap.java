package com.yibo.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Trap {
    public int trap(int[] height) {
        //找到该点左边最大值，右边最大值，然后求这俩值的最小值，然后减去该点。
        int sum = 0;
        int leftMax;
        int rightMax;
        int minMax = 0;
        for (int k = 1; k < height.length - 1; k++) {
            if (minMax > height[k]) {
                sum += minMax - height[k];
            } else {
                leftMax = getLeft(k, height);
                rightMax = getRight(k, height);
                minMax = leftMax < rightMax ? leftMax : rightMax;
                if (minMax > height[k]) {
                    sum += minMax - height[k];
                } else {
                    leftMax = height[k];
                    minMax = leftMax < rightMax ? leftMax : rightMax;
                }
            }
        }
        return sum;
    }

    private int getLeft(int i, int[] height) {
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            list.add(height[j]);
        }
        return list.stream().max(Comparator.comparingInt(a -> a)).get();
    }

    private int getRight(int i, int[] height) {
        List<Integer> list = new ArrayList<>();
        for (int j = i + 1; j < height.length; j++) {
            list.add(height[j]);
        }
        return list.stream().max(Comparator.comparingInt(a -> a)).get();
    }
}