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

    @Override
    public String toString() {
        if (array == null || array.isEmpty()) {
            return "[]";
        }
        int size = getSize();
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = size - 1; i > 0; i--) {
            result.append(array.get(i)).append(", ");
        }
        result.append(array.get(0)).append("]");
        return result.toString();
    }
}