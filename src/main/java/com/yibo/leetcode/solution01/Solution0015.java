package com.yibo.leetcode.solution01;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author yibo
 */
public class Solution0015 {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.merge(num, 1, (a, b) -> (a + b));
        }
        List<List<Integer>> res = new ArrayList<>();
        Integer i0 = counter.get(0);
        if (i0 != null && i0 >= 3) {
            res.add(Arrays.asList(0, 0, 0));
        }
        Set<Integer> keySet = counter.keySet();
        List<Integer> list = new ArrayList<>(keySet);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            Integer int1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Integer int2 = list.get(j);
                if (int1 * 2 + int2 == 0 && counter.get(int1) > 1) {
                    res.add(Arrays.asList(int1, int1, int2));
                }
                if (int2 * 2 + int1 == 0 && counter.get(int2) > 1) {
                    res.add(Arrays.asList(int1, int2, int2));
                }
                int c = 0 - int1 - int2;
                if (c > int2 && counter.get(c) != null) {
                    res.add(Arrays.asList(int1, int2, c));
                }
            }
        }
        return res;
    }
}
