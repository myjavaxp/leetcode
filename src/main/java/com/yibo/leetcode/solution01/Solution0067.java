package com.yibo.leetcode.solution01;

/**
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
public class Solution0067 {
    public String addBinary(String a, String b) {
        boolean flag = false;
        StringBuilder res = new StringBuilder();
        int al = a.length();
        int bl = b.length();
        for (int i = 0; i < Math.max(al, bl); i++) {
            if (i < al && i < bl) {
                char aChar = a.charAt(al - i - 1);
                char bChar = b.charAt(bl - i - 1);
                int t = flag ? aChar - '0' + bChar - '0' + 1 : aChar - '0' + bChar - '0';
                if (t < 2) {
                    flag = false;
                    res.append(t);
                } else {
                    flag = true;
                    res.append(t - 2);
                }
            } else if (i >= al) {
                char bChar = b.charAt(bl - i - 1);
                int t = flag ? bChar - '0' + 1 : bChar - '0';
                if (t < 2) {
                    flag = false;
                    res.append(t);
                } else {
                    flag = true;
                    res.append(t - 2);
                }
            } else {
                char aChar = a.charAt(al - i - 1);
                int t = flag ? aChar - '0' + 1 : aChar - '0';
                if (t < 2) {
                    flag = false;
                    res.append(t);
                } else {
                    flag = true;
                    res.append(t - 2);
                }
            }
        }
        if (flag) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}
