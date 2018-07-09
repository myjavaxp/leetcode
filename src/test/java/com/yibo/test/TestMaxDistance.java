package com.yibo.test;

import com.yibo.leetcode.*;
import org.junit.Test;

import java.util.List;

public class TestMaxDistance {
    @Test
    public void test01() {
        int i = MaxDistance.maxDistToClosest(new int[]{0, 1, 0, 0, 0, 0});
        System.out.println(i);
    }

    @Test
    public void test02() {
        IncreaseSequence increaseSequence = new IncreaseSequence();
        List<List<Integer>> list = increaseSequence.findSubsequences(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
        list.forEach(System.out::println);
        System.out.println(list.size());
    }

    @Test
    public void test03() {
        String s = ReverseWord.reverseWords("the best football       ");
        System.out.println(s);
        System.out.println(s.length());
    }

    @Test
    public void test04() {
        LemonadeChange lemonadeChange = new LemonadeChange();
        System.out.println(lemonadeChange.lemonadeChange(new int[]{10}));
    }

    @Test
    public void test05() {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String palindrome = longestPalindrome.longestPalindrome("abcbaabcdcba");
        System.out.println(palindrome);
    }

    @Test
    public void test06() {
        PerfectNumber perfectNumber = new PerfectNumber();
        System.out.println(perfectNumber.checkPerfectNumber(28));
    }

    @Test
    public void test07() {
        System.out.println(BiggestNum.gcd(6, 15));
    }
}