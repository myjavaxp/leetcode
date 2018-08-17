package com.yibo.leetcode.structrue;

public interface Queue<E> {
    void enqueue(E e);

    E dequeue();

    E getFront();

    int size();

    boolean isEmpty();
}
