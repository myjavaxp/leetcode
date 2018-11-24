package com.yibo.test;

import com.yibo.leetcode.structrue.Map;
import com.yibo.leetcode.structrue.map.BinaryTreeMap;
import org.junit.Test;

public class TestMap {
    @Test
    public void test01() {
        Map<Integer, Integer> map = new BinaryTreeMap<>();
        int[] strings = {100, 101, 102, 99, 10000, 103, 103, 103};
        for (int s : strings) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        System.out.println(map);
        map.remove(99);
        System.out.println(map.size());
        System.out.println(map.get(100));
    }
}
