package com.yibo.leetcode.jvm;

/**
 * 大对象直接进入老年代
 * 运行参数
 * -XX:+UseSerialGC
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -Xlog:gc*
 * -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=3145728
 */
public class BigObject {
    private static void test() {
        byte[] allocation = new byte[6 * 1024 * 1024];
    }

    public static void main(String[] args) {
        test();
    }
}
