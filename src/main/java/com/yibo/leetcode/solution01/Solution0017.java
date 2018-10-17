package com.yibo.leetcode.solution01;

import java.util.ArrayList;
import java.util.List;

public class Solution0017 {
    private List<String> res = new ArrayList<>();
    private static final String[] LETTER_MAP = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private void findCombinations(String digits, int index, String s) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        char c = digits.charAt(index);
        String letters = LETTER_MAP[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombinations(digits, index + 1, s + letters.charAt(i));
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return res;
        }
        findCombinations(digits, 0, "");
        return res;
    }
}
