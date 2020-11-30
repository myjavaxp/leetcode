package com.yibo.leetcode.solution01;

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 */
public class Solution0767 {
    public String reorganizeString(String S) {
        int[] map = new int[26];
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int index = c - 'a';
            map[index]++;
        }
        int maxIndex = 0;
        int max = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] > max) {
                max = map[i];
                maxIndex = i;
            }
        }

        if (max > S.length() - max + 1) {
            return "";
        }
        map[maxIndex] = 0;
        char current = (char) ('a' + maxIndex);
        ListNode root = new ListNode(current);
        ListNode cur = root;
        for (int i = 0; i < max - 1; i++) {
            ListNode node = new ListNode(current);
            cur.add(node);
            cur = node;
        }
        int currentIndex = 0;
        cur = root;
        for (int i = 0; i < max - 1; ) {//插入max-1个元素
            while (map[currentIndex] == 0) {
                currentIndex++;
            }
            current = (char) ('a' + currentIndex);
            int count = map[currentIndex];
            for (int j = 0; j < count && i < max - 1; j++) {
                cur.add(new ListNode(current));
                i++;
                map[currentIndex]--;
                cur = cur.next.next;
            }
        }
        cur = root;
        while (true) {
            while (currentIndex < map.length && map[currentIndex] == 0) {
                currentIndex++;
            }
            if (currentIndex == map.length) {
                break;
            }
            int count = map[currentIndex];
            current = (char) ('a' + currentIndex);
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    ListNode node = new ListNode(current);
                    node.next = root;
                    root = node;
                } else {
                    cur.add(new ListNode(current));
                    cur = cur.next.next;
                }
                map[currentIndex]--;
            }
            cur = root;
        }
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.value);
            cur = cur.next;
        }
        return sb.toString();

    }

    private static class ListNode {
        private final char value;
        private ListNode next;

        private ListNode(char value) {
            this.value = value;
        }

        private void add(ListNode node) {
            node.next = this.next;
            this.next = node;
        }
    }
}
