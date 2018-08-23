package com.yibo.leetcode.structrue.tree;

import com.yibo.leetcode.structrue.Merger;

public class SegmentTree<E> {
    /**
     * 数组数据
     */
    private E[] data;
    /**
     * 经过merge以后的值。
     */
    private E[] tree;
    private Merger<E> merger;

    @SuppressWarnings("unchecked")
    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        System.arraycopy(arr, 0, data, 0, arr.length);
        if (arr.length < 2) {
            tree = (E[]) new Object[arr.length];
            buildSegmentTree(0, 0, data.length - 1);
        } else {
            tree = (E[]) new Object[arr.length * 4 - 5];
            buildSegmentTree(0, 0, data.length - 1);
        }
    }

    /**
     * 更改某位置的值
     *
     * @param index 索引位置
     * @param e     新值
     */
    public void set(int index, E e) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal!");
        }
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    /**
     * 递归方法
     *
     * @param treeIndex 递归的节点索引
     * @param l         递归左边界
     * @param r         递归右边界
     * @param index     要替换的元素位置
     * @param e         新的元素的值
     */
    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (index > mid) {//如果要替换的元素位置大于等于中间值。则去右子树设置
            set(rightTreeIndex, mid + 1, r, index, e);
        } else {
            set(leftTreeIndex, l, mid, index, e);
        }
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public E query(int left, int right) {
        if (left < 0 || left >= data.length
                || right < 0 || right >= data.length
                || left > right) {
            throw new IllegalArgumentException("Index is illegal!");
        }
        return query(0, 0, data.length - 1, left, right);
    }

    private E query(int treeIndex, int l, int r, int left, int right) {
        if (l == left && r == right) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (left >= mid + 1) {
            return query(rightTreeIndex, mid + 1, r, left, right);
        }
        if (right <= mid) {
            return query(leftTreeIndex, l, mid, left, right);
        }
        E leftResult = query(leftTreeIndex, l, mid, left, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, right);
        return merger.merge(leftResult, rightResult);
    }

    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);
        //这里业务相关
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int size() {
        return data.length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal!");
        }
        return data[index];
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName()).append(": [");
        for (int i = 0; i < tree.length; i++) {
            if (i != tree.length - 1) {
                if (tree[i] != null) {
                    stringBuilder.append("(").append(i).append(":").append(tree[i]).append(")").append(", ");
                } else {
                    stringBuilder.append("(").append(i).append(":").append("null").append(")").append(", ");
                }
            } else {
                if (tree[i] != null) {
                    stringBuilder.append("(").append(i).append(":").append(tree[i]).append(")]");
                } else {
                    stringBuilder.append("(").append(i).append(":").append("null").append(")]");
                }
            }
        }
        return stringBuilder.toString();
    }
}