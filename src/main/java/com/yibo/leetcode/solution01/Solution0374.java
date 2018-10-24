package com.yibo.leetcode.solution01;

public class Solution0374 {
    public int guessNumber(int n) {
        int start = 1, end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int guess = guess(mid);
            if (guess == 0) {
                return mid;
            } else if (guess == -1) {
                end = mid - 1;
            } else if (guess == 1) {
                start = mid + 1;
            }
        }
        return start;
    }

    private int guess(int num) {
        return Integer.compare(num, 6);
    }
}