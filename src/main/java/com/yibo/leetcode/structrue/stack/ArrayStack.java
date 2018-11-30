package com.yibo.leetcode.structrue.stack;

import com.yibo.leetcode.structrue.Stack;

import java.util.ArrayList;

public class ArrayStack<E> implements Stack<E> {
    private ArrayList<E> array;

    public ArrayStack() {
        array = new ArrayList<>();
    }

    public ArrayStack(int capacity) {
        array = new ArrayList<>(capacity);
    }

    @Override
    public void push(E e) {
        array.add(e);
    }

    @Override
    public E pop() {
        return array.remove(array.size() - 1);
    }

    @Override
    public E peek() {
        return array.get(array.size() - 1);
    }

    @Override
    public int getSize() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
}