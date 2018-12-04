package com.yibo.test;

import com.yibo.leetcode.structrue.stack.ArrayStack;
import org.junit.Test;

import java.util.Random;

public class TestStack {
    @Test
    public void test01() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        Random random = new Random();
        int a;
        for (int i = 0; i < 10; i++) {
            a = random.nextInt(1000);
            stack.push(a);
            System.out.println("push:" + a);
        }
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}