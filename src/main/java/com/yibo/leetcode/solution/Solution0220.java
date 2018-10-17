package com.yibo.leetcode.solution;

import java.util.TreeSet;

public class Solution0220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> record = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = record.ceiling((long) nums[i] - t);
            if (ceiling != null && ceiling <= (long) nums[i] + t) {
                return true;
            }
            record.add((long) nums[i]);
            if (record.size() == k + 1) {
                record.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
