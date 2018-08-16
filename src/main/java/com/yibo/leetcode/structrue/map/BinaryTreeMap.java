package com.yibo.leetcode.structrue.map;

import com.yibo.leetcode.structrue.Map;

public class BinaryTreeMap<K extends Comparable<K>, V> implements Map<K, V> {
    private Node root;
    private int size;

    @Override
    public V put(K key, V value) {
        root = add(root, key, value);
        return value;
    }

    private Node add(Node node, K key, V value) {
        if (key == null) {
            return node;
        }
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node == null) {
            return null;
        }
        root = remove(root, key);
        return node.value;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (node.key.equals(key)) {
            if (node.left == null) {
                return replaceByRight(node);
            }
            if (node.right == null) {
                Node left = node.left;
                size--;
                node.left = null;
                return left;
            }
            Node min = minimum(node.right);
            min.left = node.left;
            min.right = removeMin(node.right);
            node.left = node.right = null;
            return min;
        }
        if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
        } else {
            node.left = remove(node.left, key);
        }
        return node;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            return replaceByRight(node);
        }
        node.left = removeMin(node.left);
        return node;
    }

    private Node replaceByRight(Node node) {
        Node right = node.right;
        size--;
        node.right = null;
        return right;
    }

    @Override
    public boolean containsKey(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;

        private Node() {
        }

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + key.toString() + " : " + value.toString() + "]";
        }
    }

    private Node getNode(Node node, K key) {
        if (node == null || key == null) {
            return null;
        }
        if (node.key.equals(key)) {
            return node;
        }
        if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        }
        return getNode(node.left, key);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName()).append(": ");
        generateString(root, stringBuilder);
        String string = stringBuilder.toString();
        return string.substring(0, string.length() - 3);
    }

    private void generateString(Node node, StringBuilder stringBuilder) {
        if (node == null) {
            return;
        }
        stringBuilder.append(node).append(" : ");
        generateString(node.left, stringBuilder);
        generateString(node.right, stringBuilder);
    }
}
