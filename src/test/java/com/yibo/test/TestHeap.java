package com.yibo.test;

import com.yibo.leetcode.solution01.Solution0347;
import com.yibo.leetcode.structrue.heap.MaxHeap;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestHeap {
    @Test
    public void test01() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        Random random = new Random();
        int n = 100;
        for (int i = 0; i < n; i++) {
            heap.add(random.nextInt(10000));
        }
        System.out.println(heap);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = heap.extractMax();
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                throw new RuntimeException("ERROR");
            }
        }
        System.out.println("正确排序");
        System.out.println(heap);
        MaxHeap<Long> maxHeap = new MaxHeap<>(new Long[3]);
        System.out.println(maxHeap.isEmpty());
    }

    @Test
    public void test02() {
        int n = 10000000;
        Integer[] testData = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testHeap(testData, false);
        double time2 = testHeap(testData, true);
        System.out.println("使用heapify的时间:" + time2);
        System.out.println("不使用heapify的时间:" + time1);
    }

    @Test
    public void test03() {
        Solution0347 solution0347 = new Solution0347();
        int[] arr = {5, 2, 5, 3, 5, 3, 1, 1, 3};
        List<Integer> list = solution0347.topKFrequent(arr, 2);
        System.out.println(list);
    }

    private double testHeap(Integer[] testData, boolean isHeapify) {
        long start = System.nanoTime();
        MaxHeap<Integer> heap;
        if (isHeapify) {
            heap = new MaxHeap<>(testData);
        } else {
            heap = new MaxHeap<>();
            for (Integer i : testData) {
                heap.add(i);
            }
        }
        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = heap.extractMax();
        }
        for (int i = 0; i < testData.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                throw new RuntimeException("ERROR");
            }
        }
        System.out.println("正确排序");
        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }
}
