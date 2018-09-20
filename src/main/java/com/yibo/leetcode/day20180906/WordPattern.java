package com.yibo.leetcode.day20180906;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/word-pattern/description/
 *
 * @author Yibo
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        if (s.length != pattern.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            char c1 = pattern.charAt(i);
            String c2 = s[i];
            if (!Objects.equals(map1.get(c1), map2.get(c2))) {
                return false;
            }
            map1.put(c1, i);
            map2.put(c2, i);
        }
        return true;
    }
}
