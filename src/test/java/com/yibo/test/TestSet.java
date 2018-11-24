package com.yibo.test;

import com.yibo.leetcode.structrue.Set;
import com.yibo.leetcode.structrue.list.LinkedList;
import com.yibo.leetcode.structrue.set.LinkedListSet;
import org.junit.Test;

import java.util.Random;

public class TestSet {
    @Test
    public void test01() {
        Set<Integer> set = new LinkedListSet<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            set.add(random.nextInt(1000));
        }
        System.out.println(set.size());
        System.out.println(set);
        for (int i = 0; i < 100; i++) {
            if (set.contains(i)) {
                System.out.println("移除元素：" + i);
                set.remove(i);
                System.out.println(set);
                System.out.println(set.size());
                break;
            }
        }
    }

    @Test
    public void test02() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            list.addFirst(i);
        }
        list.addFirst(1);
        list.removeElement(1);
        System.out.println(list);
    }
}
