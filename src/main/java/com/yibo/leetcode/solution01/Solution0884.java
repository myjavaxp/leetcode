package com.yibo.leetcode.solution01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution0884 {
    public String[] uncommonFromSentences(String A, String B) {
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String e : a) {
            map.merge(e, 1, (x, y) -> x + y);
        }
        for (String e : b) {
            map.merge(e, 1, (x, y) -> x + y);
        }
        List<String> list = new ArrayList<>();
        map.forEach((k, v) -> {
            if (v.equals(1)) {
                list.add(k);
            }
        });
        String[] res = new String[list.size()];
        return list.toArray(res);
    }
}
