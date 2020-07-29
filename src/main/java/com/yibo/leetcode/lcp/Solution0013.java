package com.yibo.leetcode.lcp;

public class Solution0013 {
    public int minimalSteps(String[] maze) {
        int m = maze.length;
        int n = maze[0].length();
        boolean[][] visited = new boolean[m][n];
        Position start = new Position();
        Position target = new Position();
        for (int i = 0; i < maze.length; i++) {
            String row = maze[i];
            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == 'S') {
                    start.x = i;
                    start.y = j;
                }
                if (row.charAt(j) == 'T') {
                    target.x = i;
                    target.y = j;
                }
            }
        }
        return -1;
    }

    private static class Position {
        private int x;
        private int y;
    }
}
