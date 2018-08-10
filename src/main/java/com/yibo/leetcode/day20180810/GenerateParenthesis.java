package com.yibo.leetcode.day20180810;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            return Collections.singletonList("()");
        }
        return getString(2 * n);
    }

    private List<String> getString(int n) {
        int max = 1 << n;
        List<String> list = new ArrayList<>();
        for (int loop = max / 2; loop < max; loop++) {
            int temp = loop;
            StringBuilder string = new StringBuilder();
            int a = 0;
            int b = 0;
            while (temp > 0 && a <= b) {
                if ((temp & 1) > 0) {
                    string.append(")");
                    a++;
                } else {
                    string.append("(");
                    b++;
                }
                temp >>= 1;
            }
            String s = string.toString();
            if (a == b && s.length() == n) {
                list.add(s);
            }
        }
        return list;
    }
}