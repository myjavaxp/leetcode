package com.yibo.leetcode.solution01;

import java.util.ArrayList;
import java.util.List;

public class Solution0866 {
    public int primePalindrome(int N) {
        ArrayList<Integer> list = new ArrayList<>();
        while (N > 0) {
            list.add(N % 10);
            N = N / 10;
        }
        boolean flag = true;
        for (int i = 0; i <= (list.size() - 1) / 2; i++) {
            Integer r = list.get(i);
            Integer l = list.get(list.size() - 1 - i);
            if (l > r) {
                list.set(i, l);
                flag = false;
            } else if (l < r) {
                if (l % 2 == 0 || i != 0) {
                    list.set(i, l + 1);
                    list.set(list.size() - 1 - i, l + 1);
                } else {
                    list.set(i, l + 2);
                    list.set(list.size() - 1 - i, l + 2);
                }
                flag = false;
                break;
            }
        }
        if (!flag) {

        }

        return 0;
    }

    private int toInt(List<Integer> list) {
        int factor = 1;
        int res = 0;
        for (Integer i : list) {
            res += i * factor;
            factor *= 10;
        }
        return res;
    }

    private boolean isPrime(int m) {
        if (m == 1) {
            return false;
        }
        if (m == 2) {
            return true;
        }
        for (int i = 2; i * i <= m; i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution0866 solution0866 = new Solution0866();

        for (int i = 0; i < 100; i++) {
            System.out.println(i + ":" + solution0866.isPrime(i));
        }
    }
}
