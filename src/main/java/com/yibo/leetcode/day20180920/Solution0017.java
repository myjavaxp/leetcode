package com.yibo.leetcode.day20180920;

import java.util.*;

public class Solution0017 {
    public List<String> letterCombinations(String digits) {
        if (digits.length() < 2) {
            return getSingle(digits);
        }
        List<String> removeFirst = letterCombinations(digits.substring(1));
        List<String> first = getSingle(digits.substring(0, 1));
        Set<String> set = new HashSet<>();
        for (String s : removeFirst) {
            for (String f : first) {
                set.add(f + s);
            }
        }
        return new ArrayList<>(set);
    }

    private List<String> getSingle(String digit) {
        List<String> list;
        switch (digit) {
            case "2":
                list = Arrays.asList("a", "b", "c");
                break;
            case "3":
                list = Arrays.asList("d", "e", "f");
                break;
            case "4":
                list = Arrays.asList("g", "h", "i");
                break;
            case "5":
                list = Arrays.asList("j", "k", "l");
                break;
            case "6":
                list = Arrays.asList("m", "n", "o");
                break;
            case "7":
                list = Arrays.asList("p", "q", "r", "s");
                break;
            case "8":
                list = Arrays.asList("t", "u", "v");
                break;
            case "9":
                list = Arrays.asList("w", "x", "y", "z");
                break;
            default:
                list = new ArrayList<>();
                break;
        }
        return list;
    }
}
