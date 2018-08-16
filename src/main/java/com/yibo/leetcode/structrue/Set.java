package com.yibo.leetcode.structrue;

public interface Set<E> {
    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int size();

    boolean isEmpty();
}
