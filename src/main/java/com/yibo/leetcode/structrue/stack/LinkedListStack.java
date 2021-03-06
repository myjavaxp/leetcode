package com.yibo.leetcode.structrue.stack;

import com.yibo.leetcode.structrue.Stack;

import java.util.LinkedList;

public class LinkedListStack<E> implements Stack<E> {
    private final LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.remove(0);
    }

    @Override
    public E peek() {
        return list.get(0);
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
