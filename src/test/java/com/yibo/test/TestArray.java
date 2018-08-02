package com.yibo.test;

import com.yibo.leetcode.structrue.Array;
import org.junit.Test;

public class TestArray {
    @Test
    public void test01() {
        Array array = new Array(20);
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
        array.set(0,1);
        array.set(1,1);
        array.set(2,1);
        array.set(3,1);
        array.set(8,1);
        System.out.println(array);
        array.removeAllElement(1);
        System.out.println(array);
        array.remove(0);
        System.out.println(array);
        System.out.println(array.size());
        System.out.println(array.removeElement(4));
        Array arr=new Array();
        System.out.println(arr.isEmpty());
        arr.addFirst(123);
        arr.addFirst(1);
        arr.addFirst(1);
        arr.addFirst(1);
        arr.addFirst(1);
        arr.addFirst(2);
        System.out.println(arr);
    }
}
