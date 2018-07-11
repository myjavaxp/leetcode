package com.yibo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个由无重复的正整数组成的集合, 找出其中最大的整除子集, 子集中任意一对 (Si, Sj) 都要满足: Si % Sj = 0 或 Sj % Si
 * = 0。
 * <p>
 * 如果有多个目标子集，返回其中任何一个均可。
 * <p>
 * 示例 1:
 * <p>
 * 集合: [1,2,3]
 * <p>
 * 结果: [1,2] (当然, [1,3] 也正确) 示例 2:
 * <p>
 * 集合: [1,2,4,8]
 * <p>
 * 结果: [1,2,4,8]
 * https://leetcode-cn.com/problems/largest-divisible-subset/description/
 *
 * @author Yibo
 */
public class LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (isDivisibleSubset(nums)) {
            for (int n : nums) {
                list.add(n);
            }
            return list;
        }
        return null;
    }
    private static List<Integer> getSubList(int[] nums,int n){
        return null;
    }
    private static boolean isDivisibleSubset(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if ((nums[i] > nums[j] ? nums[i] % nums[j] : nums[j] % nums[i]) != 0) {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> list = largestDivisibleSubset(new int[]{1, 2, 4, 8});
        System.out.println(list);
    }
}