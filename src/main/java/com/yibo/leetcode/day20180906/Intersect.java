package com.yibo.leetcode.day20180906;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/description/
 *
 * @author Yibo
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.merge(i, 1, Integer::sum);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (map.get(i) != null && map.get(i) > 0) {
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}