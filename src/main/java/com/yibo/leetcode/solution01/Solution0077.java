package com.yibo.leetcode.solution01;

import java.util.ArrayList;
import java.util.List;

public class Solution0077 {
    private final List<List<Integer>> res = new ArrayList<>();

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
            //System.out.println("获得一个集合:" + c);
            return;
        }
        /*
         * 这里的结束条件为，剩余可查找的数字个数为n-i+1个，而容器剩余容量为k-c.size()个
         * 剩余数字太少将填不满容器，故n-1+1>=k-size()
         */
        for (int i = start; i <= n - (k - c.size()) + 1; i++) {
            c.add(i);
            generateCombinations(n, k, i + 1, c);
            //移除容器最后一个元素，然后返回上一层递归循环
            //System.out.println("从:" + c + "移除元素");
            c.remove(c.size() - 1);
        }
    }

    /**
     * 从1～n这n个数字中取k个互不相同的数字，求解所有可能性
     *
     * @param n n个数字
     * @param k 容器大小
     * @return 所有可能性
     */
    public List<List<Integer>> combine(int n, int k) {
        if (k < 1 || k > n) {
            return res;
        }
        generateCombinations(n, k, 1, new ArrayList<>());
        return res;
    }
}
