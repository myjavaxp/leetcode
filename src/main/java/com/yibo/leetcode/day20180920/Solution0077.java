package com.yibo.leetcode.day20180920;

import java.util.ArrayList;
import java.util.List;

public class Solution0077 {
    private List<List<Integer>> res = new ArrayList<>();

    /**
     * 求解C(n,k),当前已找到的组合存放在c中，需要从start开始搜索新的元素
     *
     * @param n     n
     * @param k     k
     * @param start start
     * @param c     c
     */
    private void generateCombinations(int n, int k, int start, List<Integer> c) {
        if (c.size() == k) {
            res.add(new ArrayList<>(c));
            return;
        }
        for (int i = start; i <= n - (k - c.size()) + 1; i++) {
            c.add(i);
            generateCombinations(n, k, i + 1, c);
            c.remove(c.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n < 1 || k < 1 || k > n) {
            return res;
        }
        generateCombinations(n, k, 1, new ArrayList<>());
        return res;
    }
}
