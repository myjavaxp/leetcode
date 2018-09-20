package com.yibo.leetcode.day20180906;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/isomorphic-strings/description/
 *
 * @author Yibo
 */
public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (!Objects.equals(map1.get(c1), map2.get(c2))) {
                return false;
            }
            map1.put(c1, i);
            map2.put(c2, i);
        }
        return true;
    }
}
