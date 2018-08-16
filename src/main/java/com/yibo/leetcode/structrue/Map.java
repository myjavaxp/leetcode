package com.yibo.leetcode.structrue;

public interface Map<K, V> {
    V put(K key, V value);

    V remove(K key);

    boolean containsKey(K key);

    V get(K key);

    int size();

    boolean isEmpty();
}
