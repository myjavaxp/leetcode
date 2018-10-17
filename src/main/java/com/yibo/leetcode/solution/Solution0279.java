package com.yibo.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

public class Solution0279 {
    public int numSquares(int n) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(n, 0));
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;
        while (!queue.isEmpty()) {
            Pair top = queue.poll();
            int num = top.val;
            int step = top.step;
            for (int i = 1; ; i++) {
                int a = num - i * i;
                if (a < 0) {
                    break;
                }
                if (a == 0) {
                    return step + 1;
                }
                if (!visited[a]) {
                    queue.add(new Pair(a, step + 1));
                    visited[a] = true;
                }
            }
        }
        return 0;
    }

    private class Pair {
        private int val;
        private int step;

        private Pair(int val, int step) {
            this.val = val;
            this.step = step;
        }
    }
}
