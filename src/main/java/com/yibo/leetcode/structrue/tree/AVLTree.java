package com.yibo.leetcode.structrue.tree;

import com.yibo.leetcode.structrue.Map;

import java.util.ArrayList;
import java.util.List;

public class AVLTree<K extends Comparable<K>, V> implements Map<K, V> {
    private Node root;
    private int size;

    @Override
    public V put(K key, V value) {
        root = add(root, key, value);
        return value;
    }

    @Override
    public V remove(K key) {
        return null;
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

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private Node add(Node node, K key, V value) {
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
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balanceFactor = getBalanceFactor(node);
        //平衡维护
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {//LL
            //右旋转
            return rightRotate(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {//RR
            return leftRotate(node);
        }
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {//LR
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.left) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;
        x.right = y;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    private Node leftRotate(Node y) {
        Node x = y.right;
        y.right = x.left;
        x.left = y;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    public boolean isBinaryTree() {
        List<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    private void inOrder(Node node, List<K> keys) {
        if (node == null) {
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;
        private int height;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.height = 1;
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