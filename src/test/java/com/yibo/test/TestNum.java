package com.yibo.test;

import com.yibo.leetcode.solution01.Solution0012;
import org.junit.Test;

public class TestNum {
    @Test
    public void test01() {
        Solution0012 solution = new Solution0012();
        for (int i = 0; i < 4000; i++) {
            System.out.println(i + " :的罗马数字表示为:" + solution.intToRoman(i));
        }
    }
}
