package com.yibo.leetcode.day20180920;

import java.util.Stack;

public class Solution0020 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if(stack.empty()){
                    return false;
                }
                Character top = stack.peek();
                if (c == ']' && !top.equals('[')) {
                    return false;
                }
                if (c == ')' && !top.equals('(')) {
                    return false;
                }
                if (c == '}' && !top.equals('{')) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }
}
