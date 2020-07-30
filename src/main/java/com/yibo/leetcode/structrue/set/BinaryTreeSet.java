package com.yibo.leetcode.structrue.set;

import com.yibo.leetcode.structrue.Set;
import com.yibo.leetcode.structrue.tree.BinaryTree;

public class BinaryTreeSet<E extends Comparable<E>> implements Set<E> {
    private final BinaryTree<E> tree = new BinaryTree<>();

    @Override
    public void add(E e) {
        tree.add(e);
    }

    @Override
    public void remove(E e) {
        tree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return tree.contains(e);
    }

    @Override
    public int size() {
        return tree.size();
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": [" + tree.levelOrder() + "]";
    }
}