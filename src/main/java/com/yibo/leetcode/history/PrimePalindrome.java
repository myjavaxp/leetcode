package com.yibo.leetcode.history;

/**
 * 求出大于或等于 N 的最小回文素数。
 * <p>
 * 回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。
 * <p>
 * 例如，2，3，5，7，11 以及 13 是素数。
 * <p>
 * 回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。
 * <p>
 * 例如，12321 是回文数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：6
 * 输出：7
 * 示例 2：
 * <p>
 * 输入：8
 * 输出：11
 * 示例 3：
 * <p>
 * 输入：13
 * 输出：101
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10^8
 */
public class PrimePalindrome {
    public static int primePalindrome(int N) {
        while (!isPalind(N)||!isPrime(N)){
            N++;
        }
        return N;
    }

    private static boolean isPrime(int n) {
        if (n % 10 == 0) {
            return false;
        }
        String s = Integer.valueOf(n).toString();
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != chars[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
    private static boolean isPalind(int n){
        if(n==1){
            return false;
        }
        if(n==2){
            return true;
        }
        if(n%2==0){
            return false;
        }
        for(int i=3;i<=Math.sqrt(n);){
            if(n%i==0){
                return false;
            }
            i+=2;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(primePalindrome(10));
    }
}