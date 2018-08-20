package com.yibo.leetcode.structrue;

@FunctionalInterface
public interface Merger<E> {
    E merge(E a, E b);
}