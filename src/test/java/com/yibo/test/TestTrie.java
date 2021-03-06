package com.yibo.test;

import com.yibo.leetcode.solution01.Solution0125;
import com.yibo.leetcode.structrue.tree.Trie;
import org.junit.jupiter.api.Test;

public class TestTrie {
    @Test
    public void test01() {
        Trie trie = new Trie();
        trie.add("apple");
        trie.add("徐家汇");
        System.out.println(trie.contains("apple"));
        System.out.println(trie.isPrefix("app"));
        System.out.println(trie.contains("徐"));
        System.out.println(trie.isPrefix("徐"));
    }

    @Test
    public void test02() {
        Solution0125 palindrome = new Solution0125();
        System.out.println(palindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
