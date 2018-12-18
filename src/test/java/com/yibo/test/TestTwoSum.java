package com.yibo.test;

import com.yibo.leetcode.day20180810.GenerateParenthesis;
import com.yibo.leetcode.history.Trap;
import com.yibo.leetcode.history.TwoSum;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TestTwoSum {
    @Test
    public void test01() {
        int[] ints = TwoSum.twoSum(new int[]{1, 2, 3, 4}, 5);
        for (int e : ints) {
            System.out.println(e);
        }
    }

    @Test
    public void test02() {
        Trap trap = new Trap();
        int i = trap.trap(new int[]{5, 5, 1, 7, 1, 1, 5, 2, 7, 6});
        System.out.println(i);
    }

    @Test
    public void test03() {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> strings = generateParenthesis.generateParenthesis(10);
        System.out.println(strings);
        System.out.println(2 >> 1);
    }

    @Test
    public void test04() {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    @Test
    public void test05() {
        BigDecimal num = new BigDecimal(0);
        for (int i = 0; i < 10; i++) {
            num = add(num);
        }
        System.out.println(num);
    }

    private BigDecimal add(BigDecimal num) {
        num = num.add(new BigDecimal(1));
        return num;
    }
}