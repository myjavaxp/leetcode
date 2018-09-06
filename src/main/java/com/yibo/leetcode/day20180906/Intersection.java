package com.yibo.leetcode.day20180906;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/description/
 *
 * @author Yibo
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        Set<Integer> set1 = new TreeSet<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                set1.add(i);
            }
        }
        Integer[] ret = new Integer[set1.size()];
        set1.toArray(ret);
        int[] ret1 = new int[ret.length];
        for (int i = 0; i < ret.length; i++) {
            ret1[i] = ret[i];
        }
        return ret1;
    }
}
