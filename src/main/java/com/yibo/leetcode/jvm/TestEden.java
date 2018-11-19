package com.yibo.leetcode.jvm;

/**
 * 对象优先在eden分配
 */
public class TestEden {
    private static final int _1MB = 1024 * 1024;

    private static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }

    /**
     * 运行参数
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -Xlog:gc* -XX:SurvivorRatio=8
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        testAllocation();
    }
}
