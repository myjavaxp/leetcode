package com.yibo.leetcode.day20180906;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/description/
 *
 * @author Yibo
 */
public class FrequencySort {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }
        StringBuilder result = new StringBuilder();
        Queue<Character> queue = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        queue.addAll(map.keySet());
        while (!queue.isEmpty()) {
            Character c = queue.poll();
            int num = map.get(c);
            result.append(String.valueOf(c).repeat(num));
        }
        return result.toString();
    }
}
