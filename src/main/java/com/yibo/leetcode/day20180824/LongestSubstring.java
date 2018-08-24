package com.yibo.leetcode.day20180824;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * @author Yibo
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.add(c)) {
                max = set.size() > max ? set.size() : max;
                set.clear();
                i = map.get(c);
            }
            map.put(c, i);
        }
        return set.size() > max ? set.size() : max;
    }
}
