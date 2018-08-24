package com.yibo.leetcode.day20180824;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/map-sum-pairs/description/
 */
public class MapSum {
    private Node root;

    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        char[] chars = key.toCharArray();
        for (char c : chars) {
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        //找到prefix最后char的位置
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node node) {
        int result = node.value;
        for (char c : node.next.keySet()) {
            result += sum(node.next.get(c));
        }
        return result;
    }

    private class Node {
        private int value;
        private Map<Character, Node> next = new HashMap<>();

        private Node(int value) {
            this.value = value;
        }

        private Node() {
        }
    }
}
