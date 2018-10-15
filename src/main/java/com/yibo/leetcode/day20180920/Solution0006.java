package com.yibo.leetcode.day20180920;

import java.util.HashMap;
import java.util.Map;

public class Solution0006 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        Map<Integer, String> map = new HashMap<>();
        int factor = 2 * (numRows - 1);
        for (int i = 0; i < s.length(); i++) {
            int row = i % factor;
            if (row > (numRows - 1)) {
                row = factor - row;
            }
            String v = map.get(row);
            if (v == null) {
                map.put(row, String.valueOf(s.charAt(i)));
            } else {
                map.put(row, v + s.charAt(i));
            }
        }
        for (int i = 0; i < map.size(); i++) {
            res.append(map.get(i));
        }
        return res.toString();
    }
}
