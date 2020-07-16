package com.yibo.leetcode.solution01;

public class Solution0785 {
    public boolean isBipartite(int[][] graph) {
        int[] flag = new int[graph.length];
        boolean res = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) {
                continue;
            }
            if (flag[i] != 0) {
                continue;
            }
            flag[i] = 1;
            res = res && dfs(graph, flag, i);
        }
        return res;
    }

    private boolean dfs(int[][] graph, int[] flag, int index) {
        int[] points = graph[index];
        for (int p : points) {
            if (flag[p] == 0) {
                flag[p] = -flag[index];
                if (!dfs(graph, flag, p)) {
                    return false;
                }
            } else {
                if (flag[p] + flag[index] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
