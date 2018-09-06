package com.yibo.leetcode.day20180906;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * @author Yibo
 */
public class Anagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.merge(c, 1, (a, b) -> a + b);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.get(c) == null || map.get(c) < 1) {
                return false;
            }
            Integer k = map.get(c);
            if (k - 1 == 0) {
                map.remove(c);
            } else {
                map.put(c, k - 1);
            }
        }
        return map.size() == 0;
    }
}
