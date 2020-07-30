package com.yibo.leetcode.structrue.uf;

import com.yibo.leetcode.structrue.UnionFind;

public class UnionFind2 implements UnionFind {
    private final int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    /**
     * 时间复杂度为O(h)
     *
     * @param p 元素p
     * @return p的父节点
     */
    private int find(int p) {
        if (p < 0 || p >= size()) {
            throw new RuntimeException("p is out of bound.");
        }
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        parent[pRoot] = qRoot;
    }

    @Override
    public int size() {
        return parent.length;
    }
}
