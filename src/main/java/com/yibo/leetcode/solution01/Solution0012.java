package com.yibo.leetcode.solution01;

/**
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class Solution0012 {
    public String intToRoman(int num) {
        String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            while (num >= arr[i]) {
                num = num - arr[i];
                s.append(str[i]);
            }
        }
        return s.toString();
    }
}