package com.yibo.leetcode.day20180823;

public class NumArray {
    private final int[] data;
    private final int[] sum;//一共有[数组长度+1]个元素，因为第0个元素是虚拟的0

    public NumArray(int[] nums) {
        data = new int[nums.length];
        System.arraycopy(nums, 0, data, 0, nums.length);
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];//i+1个元素之和刚好=i个元素之和（0~i-1）+索引为i的那个元素
        }
    }

    public void update(int i, int val) {
        data[i] = val;
        for (int j = i; j < data.length; j++) {
            sum[j + 1] = sum[j] + data[j];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
