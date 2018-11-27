package com.yibo.leetcode.structrue.list;

public class LinkedList<E> {
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void add(E e) {
        addLast(e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node result = dummyHead.next;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.e;
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node node = dummyHead.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.e = e;
    }

    public boolean contains(E e) {
        Node node = dummyHead.next;
        while (node != null) {
            if (node.e.equals(e)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    /**
     * 移除链表中所有和e相等的元素
     *
     * @param e 待移除的元素
     */
    public void removeElement(E e) {
        if (size == 0) {
            return;
        }
        Node cur = dummyHead.next;
        Node prev = dummyHead;
        while (cur != null) {
            if (e.equals(cur.e)) {
                prev.next = cur.next;
                cur.next = null;
                cur = prev.next;
                size--;
                continue;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node node = dummyHead.next;
        while (node != null) {
            s.append(node).append(" -> ");
            node = node.next;
        }
        s.append("null");
        return s.toString();
    }

    private class Node {
        private E e;
        private Node next;

        private Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
