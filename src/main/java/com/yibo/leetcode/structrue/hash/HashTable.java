package com.yibo.leetcode.structrue.hash;

import com.yibo.leetcode.structrue.Map;

import java.util.TreeMap;

/**
 * 简易哈希表。
 * 解决哈希冲突，需要把同一桶中的k-v给放入一个红黑树中。因此本类中的K需要实现Comparable接口
 * 但是，JDK中并没有这样要求这样，在它维护的内部类TreeNode中有个方法tieBreakOrder解决了可比性问题。
 * 我们可以借用JDK中的这个方法。
 *
 * @param <K> key
 * @param <V> value
 */
public class HashTable<K, V> implements Map<K, V> {
    private TreeMap<K, V>[] tree;
    private int size;
    private int m;

    @SuppressWarnings("unchecked")
    private HashTable(int m) {
        this.m = m;
        tree = (TreeMap<K, V>[]) new TreeMap[m];
        for (int i = 0; i < m; i++) {
            tree[i] = new TreeMap<>((a, b) -> {
                if (a instanceof Comparable) {
                    return ((Comparable) a).compareTo(b);
                } else {
                    return tieBreakOrder(a, b);
                }
            });
        }
    }

    private int tieBreakOrder(Object a, Object b) {
        int d;
        if (a == null || b == null ||
                (d = a.getClass().getName().
                        compareTo(b.getClass().getName())) == 0) {
            d = (System.identityHashCode(a) <= System.identityHashCode(b) ?
                    -1 : 1);
        }
        return d;
    }

    public HashTable() {
        this(97);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public V put(K key, V value) {
        if (key == null) {
            return null;
        }
        TreeMap<K, V> map = tree[hash(key)];
        if (!containsKey(key)) {
            size++;
        }
        map.put(key, value);
        return value;
    }

    @Override
    public V remove(K key) {
        if (key == null) {
            return null;
        }
        TreeMap<K, V> map = tree[hash(key)];
        V result = map.remove(key);
        if (map.containsKey(key)) {
            size--;
        }
        return result;
    }

    @Override
    public boolean containsKey(K key) {
        return key != null && tree[hash(key)].containsKey(key);
    }

    @Override
    public V get(K key) {
        return key != null ? tree[hash(key)].get(key) : null;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (TreeMap<K, V> e : tree) {
            if (e.size() > 0) {
                e.forEach((k, v) -> s.append(k).append("=").append(v).append(", "));
            }
        }
        int l = s.length();
        if (l > 1) {
            s.delete(l - 2, l);
        }
        s.append("]");
        return s.toString();
    }
}
