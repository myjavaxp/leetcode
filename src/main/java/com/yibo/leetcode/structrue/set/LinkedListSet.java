package com.yibo.leetcode.structrue.set;

import com.yibo.leetcode.structrue.Set;

import java.util.LinkedList;

public class LinkedListSet<E> implements Set<E> {
    private final LinkedList<E> list = new LinkedList<>();

    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeFirstOccurrence(e);
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
}
