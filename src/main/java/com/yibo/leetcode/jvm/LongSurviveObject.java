package com.yibo.leetcode.jvm;

/**
 * -XX:+UseSerialGC
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -Xlog:gc*
 * -XX:SurvivorRatio=8
 * -XX:MaxTenuringThreshold=1
 */
public class LongSurviveObject {
    private static void test() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[1024 * 1024 / 4];
        allocation2 = new byte[1024 * 1024 * 4];
        allocation3 = new byte[1024 * 1024 * 4];
        allocation3 = null;
        allocation3 = new byte[1024 * 1024 * 4];
    }

    public static void main(String[] args) {
        test();
    }
}
