package com.yibo.leetcode.solution01;

public class Solution0011 {
    public int maxArea(int[] height) {
        /*int l = 0, r = 1, max = 0, length = height.length;
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
        return max;*/
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            if (height[i] > height[j]) {
                max = Math.max(max, height[j] * (j - i));
                j--;
            } else {
                max = Math.max(max, height[i] * (j - i));
                i++;
            }
        }
        return max;
    }
}
