package com.yibo.leetcode.structrue.queue;

import com.yibo.leetcode.structrue.list.Array;
import com.yibo.leetcode.structrue.Queue;

public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
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
    public int getCapacity(){
        return array.getCapacity();
    }
}
