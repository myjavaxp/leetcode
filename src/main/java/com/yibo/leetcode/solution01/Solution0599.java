package com.yibo.leetcode.solution01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution0599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        int min = -1;
        Map<String, Integer> map2 = new HashMap<>();
        String first = list1[0];
        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
            if (first.equals(list2[i])) {
                if (min == -1) {
                    min = i;
                    res.add(first);
                }
            }
        }
        for (int i = 1; i < list1.length; i++) {
            if (map2.containsKey(list1[i])) {
                int index = i + map2.get(list1[i]);
                if (index == min) {
                    res.add(list1[i]);
                }
                if (index < min) {
                    min = index;
                    res.clear();
                    res.add(list1[i]);
                }
                if (min == -1) {
                    min = index;
                    res.add(list1[i]);
                }
            }
        }
        return res.toArray(new String[0]);
    }
}
