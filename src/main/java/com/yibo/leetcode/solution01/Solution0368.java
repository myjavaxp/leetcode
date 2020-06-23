package com.yibo.leetcode.solution01;

import java.util.ArrayList;
import java.util.List;

public class Solution0368 {
    //TODO: 还有Bug
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int[] flag = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length && flag[i] == 1) {
                if (i == nums.length - 1) {
                    if (temp.size() > res.size()) {
                        res.clear();
                        res.addAll(temp);
                    }
                    max = Integer.MIN_VALUE;
                    i = 0;
                    temp.clear();
                }
                i++;
            }
            if (temp.size() == 0) {
                temp.add(nums[i]);
                max = Math.max(max, nums[i]);
                flag[i] = 1;
            } else {
                if (max % nums[i] == 0 || nums[i] % max == 0) {
                    temp.add(nums[i]);
                    max = Math.max(max, nums[i]);
                    flag[i] = 1;
                } else {
                    if (i == nums.length - 1 && temp.size() > res.size()) {
                        res.clear();
                        res.addAll(temp);
                        max = Integer.MIN_VALUE;
                        i = 0;
                        temp.clear();
                    }
                }
            }
        }
        if (temp.size() > res.size()) {
            return temp;
        }
        return res;
    }
}
