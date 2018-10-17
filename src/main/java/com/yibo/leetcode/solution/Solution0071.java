package com.yibo.leetcode.solution;

import java.util.Stack;

/**
 * 给定一个文档 (Unix-style) 的完全路径，请进行路径简化。
 * <p>
 * 例如， path = "/home/", => "/home" path = "/a/./b/../../c/", => "/c"
 * <p>
 * 边界情况:
 * <p>
 * 你是否考虑了 路径 = "/../" 的情况？ 在这种情况下，你需返回 "/" 。 此外，路径中也可能包含多个斜杠 '/' ，如
 * "/home//foo/" 。 在这种情况下，你可忽略多余的斜杠，返回 "/home/foo" 。
 *
 * @author yibo
 */
public class Solution0071 {
    public String simplifyPath(String path) {
        if (path.isEmpty()) {
            return path;
        }
        Stack<String> stack = new Stack<>();
        int startIndex = 1;
        path += '/';
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                String curPath = path.substring(startIndex, i);
                startIndex = i + 1;
                if (curPath.equals(".") || curPath.isEmpty()) {
                    continue;
                }
                if (curPath.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(curPath);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, '/' + stack.pop());
        }
        if (res.length() == 0) {
            return "/";
        }
        return res.toString();
    }
}
