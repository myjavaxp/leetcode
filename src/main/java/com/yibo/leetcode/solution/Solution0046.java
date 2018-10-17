package com.yibo.leetcode.solution;

import java.util.LinkedList;
import java.util.List;

public class Solution0046 {
    private List<List<Integer>> res = new LinkedList<>();
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        used = new boolean[nums.length];
        generatePermutation(nums, 0, new LinkedList<>());
        return res;
    }

    /**
     * @param nums  nums
     * @param index 向这个排列的末尾添加第index+1个元素，获得一个具有index+1个元素的排列
     * @param p     保存了一个有index个元素的排列
     */
    private void generatePermutation(int[] nums, int index, LinkedList<Integer> p) {
        if (index == nums.length) {
            res.add(new LinkedList<>(p));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                p.push(nums[i]);
                used[i] = true;
                generatePermutation(nums, index + 1, p);
                p.poll();
                used[i] = false;
            }
        }
    }
}
