package com.yibo.test;

import com.yibo.leetcode.structrue.Array;
import com.yibo.leetcode.structrue.ArrayQueue;
import com.yibo.leetcode.structrue.LoopQueue;
import com.yibo.leetcode.structrue.Queue;
import org.junit.Test;

import java.util.Random;

public class TestArray {
    @Test
    public void test01() {
        Array<Integer> array = new Array<>(20);
        for (int i = 0; i < 11; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        array.add(0, 99);
        System.out.println(array);
        System.out.println(array.getCapacity());
        System.out.println(array.get(1));
        System.out.println(array.get(11));
        array.set(11, 98);
        System.out.println(array.get(11));
        System.out.println(array.contains(183291));
        System.out.println(array.find(1321));
        System.out.println(array.removeFirst());
        System.out.println(array);
        System.out.println(array.removeLast());
        System.out.println(array);
        array.set(0, 1);
        array.set(1, 1);
        array.set(2, 1);
        array.set(3, 1);
        array.set(8, 1);
        System.out.println(array);
        array.removeAllElements(1);
        System.out.println(array);
        array.remove(0);
        System.out.println(array);
        System.out.println(array.size());
        System.out.println(array.removeElement(4));
        Array<Integer> arr = new Array<>();
        System.out.println(arr.isEmpty());
        arr.addFirst(123);
        arr.addFirst(1);
        arr.addFirst(1);
        arr.addFirst(1);
        arr.addFirst(1);
        arr.addFirst(2);
        System.out.println(arr);
    }

    @Test
    public void test02() {
        Array<Integer> array = new Array<>(1);
        array.addFirst(1);
        array.addFirst(1);
        array.addFirst(1);
        array.addFirst(1);
        array.addFirst(1);
        array.addFirst(1);
        array.addFirst(1);
        System.out.println(array);
        array.remove(5);
        array.remove(4);
        array.remove(3);
        System.out.println(array);
    }

    @Test
    public void test03() {
        Queue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    @Test
    public void test04() {
        int optCount = 1000000;
        Queue<Integer> queue = new ArrayQueue<>();
        double time1 = testQueue(queue, optCount);
        queue = new LoopQueue<>();
        double time2 = testQueue(queue, optCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");
        System.out.println("LoopQueue, time: " + time2 + " s");
    }

    private double testQueue(Queue<Integer> queue, int optCount) {
        long time1 = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < optCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < optCount; i++) {
            queue.dequeue();
        }
        long time2 = System.nanoTime();
        return (time2 - time1) / 1000000000.0;
    }
}
