package com.yibo.test;

import com.yibo.leetcode.structrue.tree.AVLTree;
import com.yibo.leetcode.structrue.tree.SegmentTree;
import org.junit.Test;

import java.util.Random;

public class TestTree {
    @Test
    public void test01() {
        Integer[] nums = {-1, 0, 3, -5, 2, -1};
        SegmentTree<Integer> tree = new SegmentTree<>(nums, ((a, b) -> a + b));
        System.out.println(tree);
        System.out.println(tree.query(0, 5));
    }

    @Test
    public void test02() {
        AVLTree<Integer, Integer> map = new AVLTree<>();
        Random random = new Random();
        for (int i = 0; i <10000; i++) {
            map.put(random.nextInt(10000000), 0);
        }
        System.out.println(map.isBalanced());
        System.out.println(map.isBinaryTree());
    }
}
