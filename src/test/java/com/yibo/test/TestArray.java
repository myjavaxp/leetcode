package com.yibo.test;

import com.yibo.leetcode.day20180814.ListNode;
import com.yibo.leetcode.structrue.*;
import com.yibo.leetcode.structrue.practice.RemoveElementsSolution;
import com.yibo.leetcode.structrue.tree.BinaryTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
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
        Queue<Integer> queue = new LinkedListQueue<>();
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
        int optCount = 100000;
        Queue<Integer> queue = new ArrayQueue<>();
        double time1 = testQueue(queue, optCount);
        queue = new LoopQueue<>();
        double time2 = testQueue(queue, optCount);
        queue = new LinkedListQueue<>();
        double time3 = testQueue(queue, optCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");
        System.out.println("LoopQueue, time: " + time2 + " s");
        System.out.println("LinkedListQueue, time: " + time3 + " s");
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

    @Test
    public void test05() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 666);
        System.out.println(linkedList);
        System.out.println(linkedList.remove(2));
        System.out.println(linkedList);
    }

    @Test
    public void test06() {
        Stack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack);
    }

    @Test
    public void test07() {
        RemoveElementsSolution removeElements = new RemoveElementsSolution();
        ListNode listNode = new ListNode(new int[]{1, 2, 3, 6, 4, 5, 6});
        ListNode node = removeElements.removeElements(listNode, 6);
        System.out.println(node);
    }

    @Test
    public void test08() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        int[] arr = new int[]{3, 4, 1, 0, 99, 32};
        for (int a : arr) {
            tree.add(a);
        }
        tree.preOrder();
        tree.preOrderNo();
        System.out.println();
        tree.levelOrder();
        System.out.println(tree.contains(100));
        System.out.println(tree);
        tree.inOrder();
        System.out.println("最大值:" + tree.maximum());
        System.out.println("最小值:" + tree.minimum());
        System.out.println("移除最小值");
        System.out.println(tree.removeMin());
        System.out.println(tree);

        System.out.println("移除最大值");
        System.out.println(tree.removeMax());
        System.out.println(tree);
    }

    @Test
    public void test09() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        int n = 100;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            tree.add(random.nextInt(10000));
        }
        System.out.println(tree);
        List<Integer> list = new ArrayList<>();
        while (!tree.isEmpty()) {
            list.add(tree.removeMin());
            System.out.println("删除元素后:");
            System.out.println(tree);
        }
        System.out.println(list);
    }
}
