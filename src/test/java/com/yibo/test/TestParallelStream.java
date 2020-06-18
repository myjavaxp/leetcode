package com.yibo.test;

import com.yibo.leetcode.eight.AppleUtil;
import com.yibo.leetcode.eight.TimeUtil;
import com.yibo.leetcode.eight.domain.Apple;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TestParallelStream {
    @Test
    public void test01() {
        System.out.println(
                Stream.iterate(1L, i -> i + 1)
                        .limit(1000L)
                        .reduce(0L, Long::sum));
    }

    @Test
    public void test02() {
        List<Apple> apples = AppleUtil.generateAppleList();
        System.out.println("排序前======");
        apples.forEach(System.out::println);
        apples.sort(Comparator.comparingInt(Apple::getWeight));
        System.out.println("排序后======");
        apples.forEach(System.out::println);
    }

    private boolean isGood(Predicate<Apple> predicate, Apple apple) {
        return predicate.test(apple);
    }

    @Test
    public void test03() {
        System.out.println(TimeUtil.calTime(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println(i);
            }
        }) / 1000L);
    }
}
