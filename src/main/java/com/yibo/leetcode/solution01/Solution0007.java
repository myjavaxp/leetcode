package com.yibo.leetcode.solution01;

import java.util.Stack;

public class Solution0007 {
    public int reverse(int x) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        do {
            int e = x % 10;
            x = x / 10;
            stack.push(e);
        } while (x != 0);
        int count = 0;
        while (!stack.isEmpty()) {
            res += stack.pop() * (Math.pow(10, count));
            if (res == Integer.MAX_VALUE || res == Integer.MIN_VALUE) {
                return 0;
            }
            count++;
        }
        return res;
    }
}