package com.yibo.leetcode.day20180823;

import com.yibo.leetcode.structrue.tree.SegmentTree;

public class NumArray2 {
    private SegmentTree<Integer> segmentTree;

    public NumArray2(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public void update(int i, int val) {
        if (segmentTree == null) {
            throw new RuntimeException("空");
        }
        segmentTree.set(i, val);
    }

    public int sumRange(int i, int j) {
        if (segmentTree == null) {
            throw new RuntimeException("空");
        }
        return segmentTree.query(i, j);
    }

    public static void main(String[] args) {
        NumArray2 numArray = new NumArray2(new int[]{-1});
        System.out.println(numArray.sumRange(0, 0));
        numArray.update(0, 1);
        System.out.println(numArray.sumRange(0, 0));
    }
}
