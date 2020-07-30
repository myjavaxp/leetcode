package com.yibo.leetcode.structrue.queue;

import com.yibo.leetcode.structrue.Queue;

import java.util.ArrayList;

public class ArrayQueue<E> implements Queue<E> {
    private final ArrayList<E> array;

    public ArrayQueue(int capacity) {
        array = new ArrayList<>(capacity);
    }

    public ArrayQueue() {
        array = new ArrayList<>();
    }

    @Override
    public void enqueue(E e) {
        array.add(e);
    }

    @Override
    public E dequeue() {
        return array.remove(0);
    }

    @Override
    public E getFront() {
        return array.get(0);
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
}
