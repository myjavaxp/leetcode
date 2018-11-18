package com.yibo.leetcode.solution01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution0119 {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        result.add(1);
        int prev;
        for (int i = 1; i <= rowIndex; i++) {
            prev = 1;
            for (int j = 1; j < i; j++) {
                int temp = result.get(j);
                result.set(j, prev + result.get(j));
                prev = temp;
            }
            result.add(1);
        }
        return result;
    }
}