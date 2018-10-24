package com.yibo.leetcode.solution01;

/**
 * 速度太快的代码有点意思
 */
public class Solution0278 {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        //123456789
        while (start <= end) {
            int mid = start + (end - start) / 2;
            boolean isBad = isBadVersion(mid);
            if (isBad) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean isBadVersion(int version) {
        return version == 4;
    }
}
