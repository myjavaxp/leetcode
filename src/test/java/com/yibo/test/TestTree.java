package com.yibo.test;

import com.yibo.leetcode.structrue.tree.AVLTree;
import com.yibo.leetcode.structrue.tree.RedBlackTree;
import com.yibo.leetcode.structrue.tree.SegmentTree;
import com.yibo.leetcode.structrue.util.FileOperation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class TestTree {
    private static final String FILE_PATH = "C:\\Users\\Yibo\\IdeaProjects\\leetcode\\src\\main\\resources\\pride-and-prejudice.txt";

    @Test
    public void test01() {
        Integer[] nums = {-1, 0, 3, -5, 2, -1};
        SegmentTree<Integer> tree = new SegmentTree<>(((a, b) -> a + b), nums);
        System.out.println(tree);
        System.out.println(tree.query(1, 5));
    }

    @Test
    public void test02() {
        AVLTree<Integer, Integer> map = new AVLTree<>();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            map.put(random.nextInt(10000000), 0);
        }
        System.out.println(map.isBalanced());
        System.out.println(map.isBST());
    }

    @Test
    public void test03() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(FILE_PATH, words)) {
            System.out.println("Total words: " + words.size());

            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.put(word, map.get(word) + 1);
                else
                    map.put(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));

            System.out.println("is BST : " + map.isBST());
            System.out.println("is Balanced : " + map.isBalanced());

            for (String word : words) {
                map.remove(word);
                if (!map.isBST() || !map.isBalanced())
                    throw new RuntimeException();
            }
        }
        System.out.println();
    }

    @Test
    public void test04() {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(FILE_PATH, words)) {
            System.out.println("Total words: " + words.size());
            RedBlackTree<String, Integer> map = new RedBlackTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }
            System.out.println("Total different words: " + map.size());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }
        System.out.println();
    }
}
