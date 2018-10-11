package com.yibo.leetcode.day20180920;

import java.util.Stack;

public class Solution0150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String e : tokens) {
            if (isCal(e)) {
                int b = stack.pop();
                int a = stack.pop();
                switch (e) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                    default:
                        break;
                }
            } else {
                stack.push(Integer.valueOf(e));
            }
        }
        return stack.pop();
    }

    private boolean isCal(String e) {
        return e.equals("+") || e.equals("-") || e.equals("*") || e.equals("/");
    }
}
