package com.yibo.leetcode.solution01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * <p>
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 * <p>
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 注意：
 * <p>
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 *
 * @author yibo
 */
public class Solution0784 {
    public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new ArrayList<>(0);
        }
        int l = S.length();
        if (l == 0) {
            return Collections.singletonList("");
        }
        LinkedList<String> res = new LinkedList<>();
        res.push("");
        for (int i = 0; i < l; i++) {
            char c = S.charAt(i);
            int size = res.size();
            if (c >= 'a' && c <= 'z') {
                char d = (char) (c - 32);
                for (int j = 0; j < size; j++) {
                    String next = res.pop();
                    res.add(next + c);
                    //d-'a'=dest-'A';
                    res.add(next + d);
                }
            } else if (c >= 'A' && c <= 'Z') {
                char d = (char) (c + 32);
                for (int j = 0; j < size; j++) {
                    String next = res.pop();
                    res.add(next + c);
                    //d-'a'=dest-'A';
                    res.add(next + d);
                }
            } else {
                for (int j = 0; j < size; j++) {
                    String next = res.pop();
                    res.add(next + c);
                }
            }
        }
        return res;
    }
}
