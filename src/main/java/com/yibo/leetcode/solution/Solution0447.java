package com.yibo.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution0447 {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    map.merge(dis(points[i], points[j]), 1, (a, b) -> (a + b));
                }
            }
            for (Integer k : map.keySet()) {
                int num = map.get(k);
                res += num * (num - 1);
            }
        }
        return res;
    }

    private int dis(int[] p1, int[] p2) {
        return (p1[1] - p2[1]) * (p1[1] - p2[1]) - (p1[0] - p2[0]) * (p1[0] - p2[0]);
    }
}
