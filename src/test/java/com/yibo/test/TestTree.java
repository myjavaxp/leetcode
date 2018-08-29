package com.yibo.test;

import com.yibo.leetcode.structrue.tree.AVLTree;
import com.yibo.leetcode.structrue.tree.SegmentTree;
import org.junit.Test;

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
        map.put(10, 0);
        map.put(9, 0);
        map.put(8, 0);
        map.put(7, 0);
        map.put(6, 0);
        map.put(5, 0);
        System.out.println(map.isBalanced());
        System.out.println(map.isBinaryTree());
    }
}
