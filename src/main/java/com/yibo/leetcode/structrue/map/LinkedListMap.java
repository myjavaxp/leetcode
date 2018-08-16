package com.yibo.leetcode.structrue.map;

import com.yibo.leetcode.structrue.Map;

public class LinkedListMap<K, V> implements Map<K, V> {
    private Node dummyHead = new Node();
    private int size;

    @Override
    public V put(K key, V value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
        } else {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        }
        return value;
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
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
        private Node next;

        private Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        private Node() {
        }

        @Override
        public String toString() {
            return "[" + key.toString() + " : " + value.toString() + "]";
        }
    }

    private Node getNode(Object key) {
        if (key == null) {
            return null;
        }
        Node cur = dummyHead.next;
        while (cur != null) {
            if (key.equals(cur.key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName()).append(": ");
        Node node = dummyHead.next;
        while (node != null) {
            stringBuilder.append(node).append(" -> ");
            node = node.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }
}
