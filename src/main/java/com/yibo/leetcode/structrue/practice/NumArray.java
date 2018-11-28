package com.yibo.leetcode.structrue.practice;

import com.yibo.leetcode.structrue.tree.SegmentTree;

/**
 * https://leetcode-cn.com/problems/range-sum-query-immutable/description/
 *
 * @author Yibo
 */
public class NumArray {
    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            Integer[] integers = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                integers[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(((a, b) -> a + b), integers);
        }
    }

    public int sumRange(int i, int j) {
        if (segmentTree == null) {
            throw new RuntimeException("参数异常");
        }
        return segmentTree.query(i, j);
    }
}
