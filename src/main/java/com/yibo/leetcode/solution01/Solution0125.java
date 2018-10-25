package com.yibo.leetcode.solution01;

/**
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 *
 * @author Yibo
 */
public class Solution0125 {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (j > i) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            while (isNotOk(c1)) {
                i++;
                if (i == j) {
                    return true;
                }
                c1 = s.charAt(i);
            }
            while (isNotOk(c2)) {
                j--;
                c2 = s.charAt(j);
            }
            //下边一定是
            if (isNumber(c1) || isNumber(c2)) {
                if (c1 != c2) {
                    return false;
                }
            }
            if (!equals(c1, c2)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isNotOk(char c) {
        return !isNumber(c) && (c < 'a' || c > 'z') && (c < 'A' || c > 'Z');
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean equals(char a, char b) {
        int i = a - b;
        return i == 0 || (i == 'a' - 'A') || (i == 'A' - 'a');
    }
}
