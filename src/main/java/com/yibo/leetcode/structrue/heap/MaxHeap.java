package com.yibo.leetcode.structrue.heap;

import java.util.ArrayList;

public class MaxHeap<E extends Comparable<E>> {
    private final ArrayList<E> data;

    public MaxHeap() {
        data = new ArrayList<>();
    }

    /**
     * 构造函数 把一个数组构造为一个最大堆 从最后一个非叶子节点往回走，依次执行siftDown操作，使之成为一个最大堆
     * 此时算法复杂度为O(n)
     *
     * @param a 数组
     */
    @SafeVarargs
    public MaxHeap(E... a) {
        if (a == null) {
            data = new ArrayList<>();
        } else {
            data = new ArrayList<>(a.length);
            for (E e : a) {
                if (e != null) {
                    data.add(e);
                }
            }
            if (data.size() > 1) {
                for (int i = parent(a.length - 1); i >= 0; i--) {
                    siftDown(i);
                }
            }
        }
    }

    public MaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
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
            throw new IllegalArgumentException("Index 0 doesn't have a parent!");
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
        data.add(e);
        siftUp(data.size() - 1);
    }

    /**
     * 把某索引位置的元素正确上浮
     *
     * @param k 索引
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            swap(k, parent(k));
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
        swap(0, data.size() - 1);
        data.remove(data.size() - 1);
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.size()) {
            int j = leftChild(k);
            if (j + 1 < data.size() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j++;
            }
            //此时data.get(j)是左右俩孩子中的最大值
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    /**
     * 替换最大值，并且把新值放到正确的位置
     *
     * @param e 传入的新值
     * @return 以前的最大值
     */
    public E replace(E e) {
        if (data == null || data.size() == 0) {
            throw new IllegalArgumentException("Heap is empty!");
        }
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    @Override
    public String toString() {
        int iMax = data.size() - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(data.get(i));
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
        }
    }

    private void swap(int a, int b) {
        E temp = data.get(a);
        data.set(a, data.get(b));
        data.set(b, temp);
    }
}