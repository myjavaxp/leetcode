package com.yibo.test;

import com.yibo.leetcode.algorithm.Search;
import com.yibo.leetcode.day20180904.MoveZeroes;
import com.yibo.leetcode.util.ArrayUtil;
import com.yibo.leetcode.util.Single;
import com.yibo.leetcode.util.SingleExample;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class TestSearch {
    @Test
    void test01() {
        int n = 10000000;
        Integer[] arr = ArrayUtil.generateOrderedArray(n);
        final long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            if (i != Search.binarySearch(arr, n, i)) {
                throw new RuntimeException("二分搜索法异常");
            }
        }
        final long end = System.currentTimeMillis();
        System.out.println("搜索用时:" + (end - start) + "毫秒");
    }

    @Test
    void test02() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        SingleExample instance1 = SingleExample.getInstance();
        Constructor<SingleExample> constructor = SingleExample.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingleExample instance2 = constructor.newInstance();
        System.out.println(instance1 == instance2);
    }

    @Test
    void test03() throws Exception {
        Single s1 = Single.getInstance();
        Constructor<Single> constructor = Single.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Single s2 = constructor.newInstance();
        System.out.println(s1 == s2);
    }

    @Test
    void test04() {
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(new int[]{0, 0});
    }
}