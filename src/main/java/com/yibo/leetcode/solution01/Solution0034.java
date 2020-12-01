package com.yibo.leetcode.solution01;

public class Solution0034 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int left = 0, right = nums.length - 1, mid = (right + left) / 2;
        int equalIndex = -1;
        while (left <= right) {
            if (nums[mid] > target) {
                right = mid - 1;
                mid = (right + left) / 2;
            } else if (nums[mid] < target) {
                left = mid + 1;
                mid = (right + left) / 2;
            } else {
                equalIndex = mid;
                break;
            }
        }
        if (equalIndex == -1) {
            return res;
        }
        int leftLeft = left;
        int leftRight = equalIndex;
        int rightLeft = equalIndex;
        int rightRight = right;
        while (leftLeft <= leftRight) {
            if (leftLeft + 1 == leftRight || leftLeft == leftRight) {
                if (nums[leftLeft] == target) {
                    res[0] = leftLeft;
                } else {
                    res[0] = leftRight;
                }
                break;
            }
            mid = (leftLeft + leftRight) / 2;
            if (nums[mid] == target) {
                leftRight = mid;
            } else {
                leftLeft = mid + 1;
            }
        }
        while (rightLeft <= rightRight) {
            if (rightLeft + 1 == rightRight || rightLeft == rightRight) {
                if (nums[rightRight] == target) {
                    res[1] = rightRight;
                } else {
                    res[1] = rightLeft;
                }
                return res;
            }
            mid = (rightLeft + rightRight) / 2;
            if (nums[mid] == target) {
                rightLeft = mid;
            } else {
                rightRight = mid - 1;
            }
        }
        res[0] = leftLeft;
        res[1] = rightRight;
        return res;
    }
}
