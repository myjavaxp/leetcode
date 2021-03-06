package com.yibo.leetcode.solution01;

import java.util.HashMap;
import java.util.Map;

public class Solution0454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int aC : C) {
            for (int aD : D) {
                record.merge(aC + aD, 1, Integer::sum);
            }
        }
        int res = 0;
        for (int aA : A) {
            for (int aB : B) {
                if (record.containsKey(-aA - aB)) {
                    res += record.get(-aA - aB);
                }
            }
        }
        return res;
    }
}