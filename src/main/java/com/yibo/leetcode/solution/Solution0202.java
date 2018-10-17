package com.yibo.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/happy-number/description/
 *
 * @author Yibo
 */
public class Solution0202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int k = get(n);
            if (k == 1) {
                return true;
            }
            if (!set.add(k)) {
                return false;
            }
            n = k;
        }
    }

    private int get(int n) {
        int sum = 0;
        while (n / 10 >= 0 && n != 0) {
            int i = n % 10;
            sum += i * i;
            n = n / 10;
        }
        return sum;
    }
}