package com.yibo.test;

import com.yibo.leetcode.history.*;
import com.yibo.leetcode.solution01.Solution0005;
import org.junit.jupiter.api.Test;

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
        List<List<Integer>> list = increaseSequence
                .findSubsequences(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
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
        Solution0005 solution0005 = new Solution0005();
        String palindrome = solution0005.longestPalindrome("abba");
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

    @Test
    public void test08() {
        DivisibleSubset divisibleSubset = new DivisibleSubset();
        int[] nums = new int[]{4, 8, 10, 240};
        System.out.println(divisibleSubset.largestDivisibleSubset(nums));
    }

    @Test
    public void test09() {
        FriendRequests friendRequests = new FriendRequests();
        System.out.println(friendRequests.numFriendRequests(new int[]{73, 106, 39, 6, 26, 15, 30, 100, 71, 35, 46, 112, 6, 60, 110}));
        System.out.println(friendRequests.numFriendRequests(new int[]{20, 30, 100, 110, 120}));
    }

    @Test
    public void test10() {
        GoatLatin goatLatin = new GoatLatin();
        System.out.println(goatLatin.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}