package com.yibo.leetcode.structrue.uf;

import com.yibo.leetcode.structrue.UnionFind;

public class UnionFind6 implements UnionFind {
    private final int[] parent;
    private final int[] rank;

    public UnionFind6(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
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
        if (p != parent[p]) {
            parent[p] = find(parent[p]);//路径压缩
        }
        return parent[p];
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
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }

    @Override
    public int size() {
        return parent.length;
    }
}
