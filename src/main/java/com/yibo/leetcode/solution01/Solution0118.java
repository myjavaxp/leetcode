package com.yibo.leetcode.solution01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution0118 {
    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>(numRows);
        result.add(Collections.singletonList(1));
        for (int i = 2; i <= numRows; i++) {
            List<Integer> prev = result.get(i - 2);//长度为i-1
            List<Integer> cur = new ArrayList<>(i);
            cur.add(1);
            for (int j = 1; j < i - 1; j++) {
                cur.add(j, prev.get(j - 1) + prev.get(j));
            }
            cur.add(1);
            result.add(cur);
        }
        return result;
    }
}
