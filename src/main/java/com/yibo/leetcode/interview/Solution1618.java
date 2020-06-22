package com.yibo.leetcode.interview;

/**
 * 0 <= len(pattern) <= 1000
 * 0 <= len(value) <= 1000
 * 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
 */
public class Solution1618 {
    public boolean patternMatching(String pattern, String value) {
        if (pattern.length() == 0) {
            return value.length() == 0;
        }
        int vLen = value.length();
        int pLen = pattern.length();
        int[] freq = new int[2];
        for (int i = 0; i < pLen; i++) {
            freq[pattern.charAt(i) - 'a']++;
        }
        int al = freq[0] == 0 ? 0 : vLen / freq[0];
        for (int i = 0; i <= al; i++) {
            if (freq[1] != 0 && (vLen - i * freq[0]) % freq[1] != 0) {
                continue;
            }
            if (freq[1] == 0 && i * freq[0] != vLen) {
                continue;
            }
            int bl = freq[1] == 0 ? 0 : (vLen - i * freq[0]) / freq[1];
            if (match(pattern, value, i, bl)) {
                return true;
            }
        }
        return false;
    }

    private boolean match(String p, String v, int al, int bl) {
        String ap = null;
        String bp = null;
        int start = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == 'a') {
                String t = v.substring(start, start + al);
                if (ap == null) {
                    ap = t;
                } else if (!ap.equals(t)) {
                    return false;
                }
                start += al;
            } else {
                String t = v.substring(start, start + bl);
                if (bp == null) {
                    bp = t;
                } else if (!bp.equals(t)) {
                    return false;
                }
                start += bl;
            }
            if (ap != null && ap.equals(bp)) {
                return false;
            }
        }
        return true;
    }
}
