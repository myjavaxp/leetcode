package com.yibo.leetcode.structrue;

public interface Stack<E> {
    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}