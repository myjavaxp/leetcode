package com.yibo.leetcode.structrue.uf;

import com.yibo.leetcode.structrue.UnionFind;

/**
 * 并查集
 *
 * @author Yibo
 */
public class UnionFind1 implements UnionFind {
    private int[] id;

    public UnionFind1(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("size必须大于0");
        }
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    /**
     * 查看元素p所对应的集合编号，时间复杂度O(1)
     *
     * @param p 元素
     * @return 集合编号
     */
    private int find(int p) {
        if (p < 0 || p >= size()) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int a = find(p);
        int b = find(q);
        if (a == b) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == a) {
                id[i] = b;
            }
        }
    }

    @Override
    public int size() {
        return id.length;
    }
}