package com.yibo.leetcode.solution01;

public class Solution0922 {
    public int[] sortArrayByParityII(int[] A) {
        int[] result = new int[A.length];
        int a = 0;//偶数指针
        int b = 1;//奇数指针
        for (int i : A) {
            if (i % 2 == 0) {
                result[a] = i;
                a += 2;
            } else {
                result[b] = i;
                b += 2;
            }
        }
        return result;
    }
}
