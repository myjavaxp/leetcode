package com.yibo.leetcode.solution01;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class Solution0120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] min = new int[size];
        for (int i = 0; i < size; i++) {
            min[i] = triangle.get(size - 1).get(i);
        }
        for (int y = size - 2; y >= 0; y--) {
            for (int x = 0; x <= y; x++) {
                min[x] = triangle.get(y).get(x) + Math.min(min[x], min[x + 1]);
            }
        }
        return min[0];
    }
}
