package com.yibo.leetcode.solution01;

import java.util.LinkedList;
import java.util.Queue;

public class Solution0009 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        Queue<Integer> queue = new LinkedList<>();
        do {
            int e = x % 10;
            x = x / 10;
            queue.add(e);
        } while (x != 0);
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            stringBuilder.append(queue.poll());
        }
        return stringBuilder.toString().equals(s);
    }
}
