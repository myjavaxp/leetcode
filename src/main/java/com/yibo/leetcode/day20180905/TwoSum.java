package com.yibo.leetcode.day20180905;

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * @author Yibo
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = {0, numbers.length - 1};
        while (result[0] < result[1]) {
            int i = numbers[result[0]] + numbers[result[1]];
            if (i == target) {
                result[0]++;
                result[1]++;
                return result;
            }
            if (i > target) {
                result[1]--;
            } else {
                result[0]++;
            }
        }
        throw new RuntimeException("The input has no solution.");
    }
}
