package com.yibo.leetcode.day20180906;

/**
 * https://leetcode-cn.com/problems/isomorphic-strings/description/
 *
 * @author Yibo
 */
public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
