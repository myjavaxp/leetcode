package com.yibo.leetcode.day20180905;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 * 
 * @author Yibo
 */
public class LongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		int l = 0, r = -1, max = 0;
		int[] freq = new int[256];
		while (l < s.length()) {
			if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
				freq[s.charAt(++r)]++;
			} else {
				freq[s.charAt(l++)]--;
			}
			max = Math.max(max, r - l + 1);
		}
		return max;
	}
}
