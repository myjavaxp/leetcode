package com.yibo.leetcode.solution01;

/**
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 */
public class Solution0905 {
    public int[] sortArrayByParity(int[] A) {
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                //交换A[i]和A[index]
                if (i != index) {
                    int a = A[i];
                    A[i] = A[index];
                    A[index] = a;
                }
                index++;
            }
        }
        return A;
    }
}
