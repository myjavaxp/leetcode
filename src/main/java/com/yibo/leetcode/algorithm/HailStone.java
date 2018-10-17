package com.yibo.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

public class HailStone {
    public List<Integer> hailStone(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("参数必须大于0");
        }
        List<Integer> list = new ArrayList<>();
        list.add(n);
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            list.add(n);
        }
        return list;
    }
}
