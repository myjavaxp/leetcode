package com.yibo.leetcode.history;

import java.util.*;

public class DivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length < 2) {
            List<Integer> temp = new ArrayList<>();
            for (int n : nums) {
                temp.add(n);
            }
            return temp;
        }

        Arrays.sort(nums);
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(nums[0], Collections.singletonList(nums[0]));
        for (int num : nums) {
            List<Integer> list = calculate(map, num);
            map.put(num, list);
        }
        int max = 0;
        List<Integer> result = new ArrayList<>();
        for (Integer n : map.keySet()) {
            List<Integer> list = map.get(n);
            if (list.size() > max) {
                max = list.size();
                result = list;
            }
        }
        return result;
    }

    private List<Integer> calculate(Map<Integer, List<Integer>> map, int k) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> keySet = map.keySet();
        for (Integer integer : keySet) {
            if (k % integer == 0) {
                result.add(integer);
            }
        }
        result.add(k);
        return new ArrayList<>(result);
    }
}