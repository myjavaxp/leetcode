package com.yibo.leetcode.structrue.tree;

import java.util.HashMap;

/**
 * 也叫前缀树
 * 此类设计的只支持char类型
 * 扩展训练：删除操作
 * 缺点：占用空间大，可以用压缩字典树，但是缺点是维护麻烦
 * 后缀树
 */
public class Trie {
    private final Node root;
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
        if (word == null || word.length() == 0) {
            return;
        }
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node node = cur.next.get(c);
            if (node == null) {
                Node n = new Node();
                cur.next.put(c, n);
                cur = n;
            } else {
                cur = node;
            }
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
        if (word == null || word.length() == 0) {
            return false;
        }
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
        private final HashMap<Character, Node> next = new HashMap<>();

        private Node(boolean isWord) {
            this.isWord = isWord;
        }

        private Node() {
            this(false);
        }
    }
}
