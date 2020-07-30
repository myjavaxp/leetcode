package com.yibo.leetcode.structrue.queue;

import com.yibo.leetcode.structrue.Queue;
import com.yibo.leetcode.structrue.heap.MaxHeap;

/**
 * 优先队列，出队优先出队的为最大元素，即优先级最高的元素
 *
 * @param <E> 实现了{@link Comparable}接口的类型
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private final MaxHeap<E> maxHeap = new MaxHeap<>();

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public int size() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
