package com.yibo.leetcode.solution01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution0491 {
    //TODO:
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = nums.length - 2; i >= 0; i--) {
            int start = nums[i];
            List<List<Integer>> temp = new ArrayList<>();
            if (res.size() > 0) {
                res.forEach(list -> {
                    if (list.get(0) >= start) {
                        LinkedList<Integer> integers = new LinkedList<>(list);
                        integers.addFirst(start);
                        temp.add(integers);
                    }
                });
            }
            res.addAll(temp);
            int[] record = new int[201];
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (start <= nums[j]) {
                    LinkedList<Integer> member = new LinkedList<>();
                    member.add(start);
                    member.add(nums[j]);
                    res.add(member);
                }
            }
        }
        return res;
    }
}
