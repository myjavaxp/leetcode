package com.yibo.leetcode.structrue.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 也叫前缀树
 * 此类设计的只支持char类型
 */
public class Trie {
    private Node root;
    private int size;

    public Trie() {
        root = new Node();
    }

    /**
     * 包含的单词个数
     *
     * @return 单词个数
     */
    public int size() {
        return size;
    }

    /**
     * 往Trie中添加单词
     * 这里可以尝试用递归的方法来实现。
     *
     * @param word 添加的单词
     */
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 判定Trie是否包含某单词
     *
     * @param word 待查单词
     * @return 是否包含
     */
    public boolean contains(String word) {
        Node cur = root;
        return has(word, cur, false);
    }

    public boolean isPrefix(String prefix) {
        Node cur = root;
        return has(prefix, cur, true);
    }

    private boolean has(String word, Node cur, boolean isPrefix) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        if (isPrefix) {
            return true;
        }
        return cur.isWord;
    }

    private class Node {
        private boolean isWord;
        private Map<Character, Node> next;

        private Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new HashMap<>();
        }

        private Node() {
            this(false);
        }
    }
}
