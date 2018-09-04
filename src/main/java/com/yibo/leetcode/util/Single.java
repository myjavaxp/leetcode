package com.yibo.leetcode.util;

public class Single {
    private Single() {
    }

    private static class Inner {
        private static final Single SINGLE = new Single();
    }

    public static Single getInstance() {
        return Inner.SINGLE;
    }
}
