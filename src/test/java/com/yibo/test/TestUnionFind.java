package com.yibo.test;

import com.yibo.leetcode.structrue.UnionFind;
import com.yibo.leetcode.structrue.uf.UnionFind1;
import com.yibo.leetcode.structrue.uf.UnionFind2;
import com.yibo.leetcode.structrue.uf.UnionFind3;
import com.yibo.leetcode.structrue.uf.UnionFind4;
import org.junit.Test;

import java.util.Random;

public class TestUnionFind {
    @Test
    public void test01() {
        int size = 100000;
        int m = 100000;
        UnionFind uf1 = new UnionFind1(size);
        UnionFind uf2 = new UnionFind2(size);
        UnionFind uf3 = new UnionFind3(size);
        UnionFind uf4 = new UnionFind4(size);
        System.out.println(test(uf1, m));
        System.out.println(test(uf2, m));
        System.out.println(test(uf3, m));
        System.out.println(test(uf4, m));
    }

    private double test(UnionFind unionFind, int m) {
        int size = unionFind.size();
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            unionFind.unionElements(a, b);
        }
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            unionFind.isConnected(a, b);
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
