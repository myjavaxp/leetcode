package com.yibo.leetcode.structrue.tree;

/**
 * @param <E> 泛型必须实现{@link Comparable}接口，使得其具有可比性。
 * @author Yibo
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private int size;
    private Node root;

    /**
     * 返回树的大小
     *
     * @return 二分查找树元素个数
     */
    public int size() {
        return size;
    }

    /**
     * 树是否为空
     *
     * @return 返回树是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 往二分查找树添加元素
     *
     * @param e 待添加的元素
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 递归插入
     *
     * @param node 递归Node
     * @param e    待插入元素
     * @return 返回node本身或者新增node
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    private class Node {
        /**
         * 节点值
         */
        private E e;
        /**
         * 左孩子
         */
        private Node left;
        /**
         * 右孩子
         */
        private Node right;

        private Node() {
        }

        private Node(E e) {
            this.e = e;
        }
    }
}
