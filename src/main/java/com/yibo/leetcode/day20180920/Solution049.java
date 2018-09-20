package com.yibo.leetcode.day20180920;

import java.util.*;

public class Solution049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strs) {
            String sort = sort(string);
            if (map.containsKey(sort)) {
                List<String> strings = map.get(sort);
                strings.add(string);
            } else {
                List<String> list = new ArrayList<>();
                list.add(string);
                map.put(sort, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    private String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}