package com.yibo.leetcode.structrue.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @param <E> 泛型需要实现{@link Comparable}接口，使得其具有可比性。
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

    /**
     * 判断树是否包含某个元素
     *
     * @param e 待查元素
     * @return 是否包含
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        }
        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        }
        return contains(node.right, e);
    }

    /**
     * 深度优先遍历
     */
    public void preOrderNo() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 层序遍历
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.println(node.e);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /**
     * 查找树的最小值
     *
     * @return 树中最小元素
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("Empty!");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 查找树的最大值
     *
     * @return 树中最大元素
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("Empty!");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public E removeMin() {
        E min = minimum();
        root = removeMin(root);
        return min;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E max = maximum();
        root = removeMax(root);
        return max;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
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

        private Node(E e) {
            this.e = e;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateString(root, 0, res);
        return res.toString();
    }

    private void generateString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth)).append("null\n");
            return;
        }
        res.append(generateDepthString(depth)).append(node.e).append("\n");
        generateString(node.left, depth + 1, res);
        generateString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("-|");
        }
        return res.toString();
    }
}