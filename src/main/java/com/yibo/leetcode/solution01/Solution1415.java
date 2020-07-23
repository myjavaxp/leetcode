package com.yibo.leetcode.solution01;

public class Solution1415 {
    public String getHappyString(int n, int k) {
        int max = 3;
        for (int i = 0; i < n - 1; i++) {
            max *= 2;
        }
        if (k > max) {
            return "";
        }
        if (n == 1) {
            return new String(new char[]{(char) ('a' + k - 1)});
        }
        char[] res = new char[n];
        helper(res, max, k, 0);

        return new String(res);
    }

    private void helper(char[] res, int max, int k, int start) {

        int levelCount = start == 0 ? max / 3 : max / 2;
        int level = k % levelCount == 0 ? k / levelCount - 1 : k / levelCount;
        if (start == 0) {
            res[start] = (char) ('a' + level);
        } else {
            char pre = res[start - 1];
            char value = 'a';
            int no = (start == res.length - 1 ? k - 1 : level);
            for (int i = 0; i < 3 && no > -1; i++) {
                if (pre == 'a' + i) {
                    continue;
                }
                value = (char) ('a' + i);
                no--;
            }
            res[start] = value;
        }
        if (start == res.length - 1) {
            return;
        }
        helper(res, max / levelCount, k - level * levelCount, start + 1);
    }
}
