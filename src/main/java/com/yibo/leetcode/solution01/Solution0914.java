package com.yibo.leetcode.solution01;

import java.util.Arrays;

/**
 * 给定一副牌，每张牌上都写着一个整数。
 * <p>
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * <p>
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例 2：
 * <p>
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 3：
 * <p>
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 4：
 * <p>
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * 示例 5：
 * <p>
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 * <p>
 * 提示：
 * <p>
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 */
public class Solution0914 {
    public boolean hasGroupsSizeX(int[] deck) {
        int max = 0;
        for (int i : deck) {
            max = max > i ? max : i;
        }
        //memo[i]表示数字i出现的次数。
        int[] memo = new int[max + 1];
        for (int i : deck) {
            memo[i]++;
        }
        Arrays.sort(memo);
        int index = 0;
        while (index <= max && memo[index] == 0) {
            index++;
        }
        if (memo[index] == 1) {
            return false;
        }
        if (index == max) {
            return true;
        }
        int x = memo[index];
        if (x % 2 != 0) {//第一个数字为奇数
            int y = memo[index + 1];
            int min = 0;
            for (int i = 3; i <= x; i++) {
                if (x % i == 0 && y % i == 0) {
                    min = i;
                    break;
                }
            }
            if (min == 0) {
                return false;
            }
            for (int i = index + 2; i <= max; i++) {
                if (memo[i] % min != 0) {
                    return false;
                }
            }
            return true;
        } else {
            int j = 0;//第一个奇数的坐标
            for (int i = index + 1; i <= max; i++) {
                if (memo[i] % 2 != 0) {
                    j = i;
                    break;
                }
            }
            if (j == 0) {
                return true;
            }
            //求第一个奇数和x的最小非1公约数
            int y = memo[j];
            int min = 0;
            for (int i = 3; i <= x; i++) {
                if (x % i == 0 && y % i == 0) {
                    min = i;
                    break;
                }
            }
            if (min == 0) {
                return false;
            }
            for (int i = index + 2; i <= max; i++) {
                if (memo[i] % min != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
