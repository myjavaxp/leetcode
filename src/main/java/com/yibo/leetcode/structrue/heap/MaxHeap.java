package com.yibo.leetcode.structrue.heap;

import com.yibo.leetcode.structrue.list.Array;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * 构造函数
     * 把一个数组构造为一个最大堆
     * 从最后一个非叶子节点往回走，依次执行siftDown操作，使之成为一个最大堆
     *
     * @param arr 数组
     */
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 获取某节点的父节点索引
     *
     * @param index 节点索引
     * @return 父节点索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("Index 0 doesn't hava parent!");
        }
        return (index - 1) / 2;
    }

    /**
     * 左子节点索引
     *
     * @param index 节点索引
     * @return 左子节点索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.size() - 1);
    }

    /**
     * 把某索引位置的元素正确上浮
     *
     * @param k 索引
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 找到最大值
     *
     * @return 最大值
     */
    public E findMax() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Heap is empty!");
        }
        return data.get(0);
    }

    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.size() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int index) {
        while (leftChild(index) < data.size()) {
            int j = leftChild(index);
            if (j + 1 < data.size() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j++;
            }
            if (data.get(index).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(index, j);
            index = j;
        }
    }

    /**
     * 替换最大值，并且把新值放到正确的位置
     *
     * @param e 传入的新值
     * @return 以前的最大值
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName()).append(": [");
        if (!isEmpty()) {
            for (int i = 0; i < size() - 1; i++) {
                stringBuilder.append(data.get(i)).append(" :: ");
            }
            stringBuilder.append(data.get(size() - 1));
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}