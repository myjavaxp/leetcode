package com.yibo.leetcode.solution01;

/**
 * 解答错误
 */
public class Solution0011 {
    public int maxArea(int[] height) {
        int l = 0, r = 1, max = 0, length = height.length;
        while (r < length) {
            int cur = (r - l) * Math.min(height[l], height[r]);
            int next = (r - l - 1) * Math.min(height[l + 1], height[r]);
            if (next >= cur) {
                l++;
                max = Math.max(max, next);
            } else {
                max = Math.max(max, cur);
            }
            r++;
        }
        return max;
    }
}
