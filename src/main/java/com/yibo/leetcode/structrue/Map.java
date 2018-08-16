package com.yibo.leetcode.structrue;

public interface Map<K, V> {
    V put(K key, V value);

    V remove(Object key);

    boolean containsKey(Object key);

    V get(Object key);

    int size();

    boolean isEmpty();
}
