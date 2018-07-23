package com.yibo.test;

import com.yibo.leetcode.Trap;
import com.yibo.leetcode.TwoSum;
import org.junit.Test;

public class TestTwoSum {
    @Test
    public void test01() {
        int[] ints = TwoSum.twoSum(new int[]{1, 2, 3, 4}, 5);
        for (int e : ints) {
            System.out.println(e);
        }
    }
    @Test
    public void test02(){
        Trap trap=new Trap();
        int i = trap.trap(new int[]{5, 5, 1, 7, 1, 1, 5, 2, 7, 6});
        System.out.println(i);
    }
}