package com.yibo.leetcode.structrue.set;

import com.yibo.leetcode.structrue.list.LinkedList;
import com.yibo.leetcode.structrue.Set;

public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> list = new LinkedList<>();

    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "LinkedListSet{" +
                "list=" + list +
                '}';
    }
}
