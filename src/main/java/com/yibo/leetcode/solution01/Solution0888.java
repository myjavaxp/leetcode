package com.yibo.leetcode.solution01;

import java.util.HashSet;
import java.util.Set;

public class Solution0888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();
        for (int i : A) {
            sumA += i;
            aSet.add(i);
        }
        for (int i : B) {
            sumB += i;
            bSet.add(i);
        }
        int[] res = new int[2];
        int target = (sumA - sumB) / 2;
        for (Integer a : aSet) {
            if (bSet.contains(a - target)) {
                res[0] = a;
                res[1] = a - target;
                return res;
            }
        }
        return null;
    }
}
