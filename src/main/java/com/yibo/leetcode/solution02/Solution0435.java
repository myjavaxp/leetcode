package com.yibo.leetcode.solution02;

import com.yibo.leetcode.model.Interval;

import java.util.Arrays;

public class Solution0435 {
    public int eraseOverlapIntervals(Interval[] intervals) {
        int length = intervals.length;
        if (length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1.end != o2.end) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });
        int res = 1;
        int pre = 0;
        for (int i = 1; i < length; i++) {
            if (intervals[i].start >= intervals[pre].end) {
                pre = i;
                res++;
            }
        }
        return length - res;
    }
}
