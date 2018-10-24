package com.yibo.leetcode.algorithm;

/**
 * 使用动态规划解决01背包问题
 * 状态迁移方程
 * 考虑将i个物品放进容量为c的背包，使得价值最大
 * f(i,c)=max(f(i-1,c),v(i)+f(i-1,c-w(i)))
 */
public class KnapsackProblem {
    /**
     * 返回一个背包问题最优方案
     *
     * @param w 每件物品的重量
     * @param v 每件物品的价值
     * @param c 背包的承重(或者说容量)
     * @return 装满背包时，物品的最大价值
     */
    public int knapsack(int[] w, int[] v, int c) {
        if (w == null || v == null || c < 1) {
            return 0;
        }
        int n = w.length;
        if (n != v.length) {
            throw new IllegalArgumentException("物品重量列表应该和物品价值列表长度一致");
        }
        if (n == 0) {
            return 0;
        }
        //每次循环刷新memo的值，循环次数j表示【考虑】放入前j个物品，下标表示容易总容量。
        int[] memo = new int[c + 1];
        //最底层的问题：尝试将第0号物品放入容器中；
        for (int j = 0; j <= c; j++) {
            memo[j] = j >= w[0] ? v[0] : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = c; j >= w[i]; j--) {
                memo[j] = Math.max(memo[j], memo[j - w[i]] + v[i]);
            }
        }
        return memo[c];
    }
}
