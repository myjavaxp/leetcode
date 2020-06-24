package com.yibo.leetcode.solution01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0368 {
    //dp[i]=1+max[dp[j]],如果nums[i]%nums[j]==0
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int maxIdx = 0;
        List<Integer>[] res = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            int max = i;
            int maxLen = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && maxLen < res[j].size()) {
                    max = j;
                    maxLen = res[j].size();
                }
            }
            res[i] = new ArrayList<>();
            res[i].addAll(res[max]);
            res[i].add(nums[i]);
            if (res[maxIdx].size() < res[i].size()) {
                maxIdx = i;
            }
        }
        return res[maxIdx];
    }
}
