package com.yibo.leetcode.structrue.uf;

import com.yibo.leetcode.structrue.UnionFind;

/**
 * size 优先合并
 *
 * @author Yibo
 */
public class UnionFind3 implements UnionFind {
    private final int[] parent;
    private final int[] sz;

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            sz[i] = 1;
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
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }

    @Override
    public int size() {
        return parent.length;
    }
}
