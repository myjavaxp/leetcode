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
	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		for (int n : nums) {
			temp.add(n);
		}
		List<List<Integer>> subsets = getSubsets(temp);
		subsets.sort((o1, o2) -> o2.size() - o1.size());
		for (List<Integer> subList : subsets) {
			if (isDivisibleSubset(subList) && subList.size() > result.size()) {
				result = subList;
			}
		}
		return result;
	}

	private boolean isDivisibleSubset(List<Integer> nums) {
		for (int i = 0; i < nums.size() - 1; i++) {
			for (int j = i + 1; j < nums.size(); j++) {
				int flag = nums.get(i) > nums.get(j) ? nums.get(i) % nums.get(j) : nums.get(j) % nums.get(i);
				if (flag != 0) {
					return false;
				}
			}
		}
		return true;
	}

	private List<List<Integer>> getSubsets(List<Integer> subList) {
		List<List<Integer>> allSubsets = new ArrayList<>();
		int max = 1 << subList.size();
		for (int loop = 0; loop < max; loop++) {
			int index = 0;
			int temp = loop;
			List<Integer> currentCharList = new ArrayList<>();
			while (temp > 0) {
				if ((temp & 1) > 0) {
					currentCharList.add(subList.get(index));
				}
				temp >>= 1;
				index++;
			}
			allSubsets.add(currentCharList);
		}
		return allSubsets;
	}
}