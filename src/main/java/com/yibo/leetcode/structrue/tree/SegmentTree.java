package com.yibo.leetcode.structrue.tree;

import com.yibo.leetcode.structrue.Merger;

import java.util.Objects;

/**
 * 线段树，可以由某种计算规则{@link Merger}来计算或者查询某个区间的数值的结果。
 * 该类只实现了单个更改值，批量更新值需要用到一个懒加载机制。
 * 思路拓展：Range Minimum Query问题
 *
 * @param <E> 存入的元素。
 * @author yibo
 */
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
    @SafeVarargs
    public SegmentTree(Merger<E> merger, E... array) {
        this.merger = Objects.requireNonNullElseGet(merger, () -> (a, b) -> null);
        if (array == null) {
            data = (E[]) new Object[0];
        } else {
            data = (E[]) new Object[array.length];
            System.arraycopy(array, 0, data, 0, array.length);
        }
        int l = data.length;
        if (l == 0) {
            tree = (E[]) new Object[0];
        } else if (l == 1) {
            tree = (E[]) new Object[l];
            tree[0] = data[0];
        } else {
            tree = (E[]) new Object[l * 4 - 5];
            build(0, 0, l - 1);
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
        return size() == 0 ? null : query(0, 0, data.length - 1, left, right);
    }

    /**
     * 其实l,r的值不能随便传的，必须是treeIndex统计的左右边界
     *
     * @param treeIndex 节点
     * @param l         节点的左边界
     * @param r         节点的右边界
     * @param left      用户查找的左边界
     * @param right     用户查询的右边界
     * @return 结果
     */
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

    private void build(int index, int l, int r) {
        if (l == r) {
            tree[index] = data[l];
            return;
        }
        int left = leftChild(index);
        int right = rightChild(index);
        int mid = l + (r - l) / 2;
        build(left, l, mid);
        build(right, mid + 1, r);
        //这里业务相关
        tree[index] = merger.merge(tree[left], tree[right]);
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
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < tree.length - 1; i++) {
            if (tree[i] != null) {
                result.append(i).append("=").append(tree[i]).append(", ");
            } else {
                result.append(i).append("=").append("null").append(", ");
            }
        }
        int l = tree.length - 1;
        if (l != -1) {
            result.append(l).append("=").append(tree[l]);
        }
        result.append("]");
        return result.toString();
    }
}