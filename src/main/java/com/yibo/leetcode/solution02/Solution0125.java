package com.yibo.leetcode.solution02;

public class Solution0125 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (right > left) {
            char l = s.charAt(left);
            while (isNotNumberAndChar(l)) {
                left++;
                if (left == right) {
                    return true;
                }
                l = s.charAt(left);
            }
            char r = s.charAt(right);
            while (isNotNumberAndChar(r)) {
                right--;
                r = s.charAt(right);
            }

            if (isNumber(l)) {
                if (l != r) {
                    return false;
                }
            } else {
                if (l != r && l - r != 'a' - 'A' && l - r != 'A' - 'a') {
                    return false;
                }
            }
            left++;
            right--;

        }
        return true;
    }

    private boolean isNotNumberAndChar(char c) {
        return (c < '0' || c > '9') && (c < 'a' || c > 'z') && (c < 'A' || c > 'Z');
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
