package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.Interval;

import java.util.Arrays;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * <p>
 * 注意:
 * <p>
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 * <p>
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 * <p>
 * 输入: [ [1,2], [1,2], [1,2] ]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 * <p>
 * 输入: [ [1,2], [2,3] ]
 * <p>
 * 输出: 0
 * <p>
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * 动态规划方法
 */
public class Solution0435 {
    public int eraseOverlapIntervals(Interval[] intervals) {
        int length = intervals.length;
        if (length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1.start != o2.start) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });
        //memo[i]表示使用intervals[0,,,,i]的能构成的最大不重叠区间
        int[] memo = new int[length];
        for (int i = 0; i < length; i++) {
            memo[i] = 1;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i].start >= intervals[j].end) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }
        int res = 0;
        for (int i : memo) {
            res = Math.max(i, res);
        }
        return length - res;
    }
}
