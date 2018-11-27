package com.yibo.test;

import com.yibo.leetcode.structrue.Map;
import com.yibo.leetcode.structrue.hash.HashTable;
import com.yibo.leetcode.structrue.map.BinaryTreeMap;
import org.junit.Test;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

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

    @Test
    public void test02() {
        HashTable<Integer, Integer> table = new HashTable<>();
        table.put(97, 1);
        table.put(97 * 2, 2);
        table.put(97 * 3, 3);
        table.put(97 * 4, 4);
        table.put(97 * 5, 5);
        table.put(97 * 6, 6);
        table.put(97 * 7, 7);
        System.out.println(table);
    }

    @Test
    public void test03() {
        HashTable<String, Integer> table = new HashTable<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            table.put(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6), random.nextInt(10000));
        }
        table.put("哈哈", 321);
        table.put(null, 0);
        table.put(null, 23);
        System.out.println(table);
        System.out.println(table.containsKey("哈哈"));
        System.out.println(table.get(null));
        HashMap<String, String> map = new HashMap<>();
        map.put(null, "空");
        System.out.println(map.get(null));
    }
}