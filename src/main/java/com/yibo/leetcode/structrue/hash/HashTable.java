package com.yibo.leetcode.structrue.hash;

import java.util.TreeMap;

/**
 * 简易哈希表。
 * 解决哈希冲突，需要把同一桶中的k-v给放入一个红黑树中。因此本类中的K需要实现Comparable接口
 * 但是，JDK中并没有这样要求这样，在它维护的内部类TreeNode中有个方法tieBreakOrder解决了可比性问题。
 *
 * @param <K> key 解决哈希冲突，本类中要求是需要实现Comparable接口，但是，JDK中并没有实现
 * @param <V> value
 */
public class HashTable<K extends Comparable<K>, V> {
    private TreeMap<K, V>[] hashTable;
    private int size;
    private int m;

    @SuppressWarnings("unchecked")
    private HashTable(int m) {
        this.m = m;
        hashTable = (TreeMap<K, V>[]) new TreeMap[m];
        for (int i = 0; i < m; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(97);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public int size() {
        return size;
    }

    public void put(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        map.put(key, value);
        if (!map.containsKey(key)) {
            size++;
        }
    }

    public V remove(K key) {
        TreeMap<K, V> map = hashTable[hash(key)];
        V result = map.remove(key);
        if (map.containsKey(key)) {
            size--;
        }
        return result;
    }

    public boolean contains(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }
}
