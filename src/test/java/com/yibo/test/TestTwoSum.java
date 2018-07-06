package com.yibo.test;

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
}