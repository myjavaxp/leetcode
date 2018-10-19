package com.yibo.leetcode.solution01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yibo
 */
public class Solution0051 {
    private List<List<String>> res = new ArrayList<>();
    //col标记每一列是否有重复，dia1每一斜列是否重复，dia2每一反斜列是否重复
    private boolean[] col, dia1, dia2;

    public List<List<String>> solveNQueens(int n) {
        res.clear();
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        putQueue(n, 0, new ArrayList<>());
        return res;
    }

    /**
     * 尝试在一个N皇后问题中，摆放第index行的皇后位置
     *
     * @param n     N皇后
     * @param index 第几行
     * @param row   数组下标为第n行，值为皇后的位置
     */
    private void putQueue(int n, int index, List<Integer> row) {
        if (index == n) {
            res.add(toStringList(row, n));
            return;
        }
        for (int i = 0; i < n; i++) {
            //尝试将第index行第皇后摆放在第i列
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                row.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueue(n, index + 1, row);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                row.remove(row.size() - 1);
            }
        }
    }

    private List<String> toStringList(List<Integer> row, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            Integer integer = row.get(i);
            for (int j = 0; j < n; j++) {
                if (integer.equals(j)) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        return list;
    }

//    public static void main(String[] args) {
//        Solution0051 solution = new Solution0051();
//        int n = 5;
//        List<List<String>> queens = solution.solveNQueens(n);
//        for (List<String> list : queens) {
//            list.forEach(System.out::println);
//            System.out.println();
//        }
//        System.out.println(queens.size());
//    }
}
