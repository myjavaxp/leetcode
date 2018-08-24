package com.yibo.leetcode.history;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * <p>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 * <p>
 * 注意：
 * <p>
 * 你可以假设两个字符串均只含有小写字母。
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * https://leetcode-cn.com/problems/ransom-note/description/
 */
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> rMap = new HashMap<>();
        Map<Character, Integer> mMap = new HashMap<>();
        char[] ransom = ransomNote.toCharArray();
        char[] array = magazine.toCharArray();
        for (char r : ransom) {
            rMap.merge(r, 1, (a, b) -> a + b);
        }
        for (char m : array) {
            mMap.merge(m, 1, (a, b) -> a + b);
        }
        Set<Character> keySet = rMap.keySet();
        for (Character character : keySet) {
            if (mMap.get(character) == null || mMap.get(character) < rMap.get(character)) {
                return false;
            }
        }
        return true;
    }
}