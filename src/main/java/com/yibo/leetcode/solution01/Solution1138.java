package com.yibo.leetcode.solution01;

public class Solution1138 {
    public String alphabetBoardPath(String target) {
        StringBuilder res = new StringBuilder();
        char cur = 'a';
        for (int i = 0; i < target.length(); i++) {
            char dest = target.charAt(i);
            if (cur == dest) {
                res.append("!");
                continue;
            }
            if (cur == 'z') {
                cur = 'u';
                res.append('U');
            }
            int curX = (cur - 'a') % 5;
            int curY = (cur - 'a') / 5;
            int destX = (dest - 'a') % 5;
            int destY = (dest - 'a') / 5;
            boolean flag = (destX - curX) > 0;
            for (int j = 0; j < Math.abs(destX - curX); j++) {
                if (flag) {
                    res.append('R');
                } else {
                    res.append('L');
                }
            }
            flag = (destY - curY) > 0;
            for (int j = 0; j < Math.abs(destY - curY); j++) {
                if (flag) {
                    res.append('D');
                } else {
                    res.append('U');
                }
            }
            res.append('!');
            cur = dest;
        }
        return res.toString();
    }
}
