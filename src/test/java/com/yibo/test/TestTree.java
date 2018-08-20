package com.yibo.test;

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
}
