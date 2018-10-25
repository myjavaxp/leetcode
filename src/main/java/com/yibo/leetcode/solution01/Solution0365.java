package com.yibo.leetcode.solution01;

/**
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * <p>
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * <p>
 * 你允许：
 * <p>
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 * <p>
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 */
public class Solution0365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if (x == 0) {
            return z == y;
        }
        if (y == 0) {
            return z == x;
        }
        if (z > x + y) {
            return false;
        }
        while (y != 0) {
            int r = x % y;//2
            //noinspection SuspiciousNameCombination
            x = y;
            y = r;
        }
        return z % x == 0;
    }
}
