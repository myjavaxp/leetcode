package com.yibo.leetcode;

/**
 * https://leetcode-cn.com/problems/judge-route-circle/description/
 *
 * @author Yibo
 */
public class JudgeCircle {
    public boolean judgeCircle(String moves) {
        int r = 0;
        int l = 0;
        int u = 0;
        int d = 0;
        char[] chars = moves.toCharArray();
        for (char c : chars) {
            switch (c) {
                case 'R':
                    r++;
                    break;
                case 'L':
                    l++;
                    break;
                case 'U':
                    u++;
                    break;
                case 'D':
                    d++;
                    break;
                default:
                    break;
            }
        }
        return r == l && u == d;
    }
}
