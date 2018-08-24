package com.yibo.leetcode.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 爱丽丝有一手（hand）由整数数组给定的牌。
 * <p>
 * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 * <p>
 * 如果她可以完成分组就返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：hand = [1,2,3,6,2,3,4,7,8], W = 3
 * 输出：true
 * 解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 * <p>
 * 输入：hand = [1,2,3,4,5], W = 4
 * 输出：false
 * 解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。
 * https://leetcode-cn.com/problems/hand-of-straights/description/
 */
public class StraightHand {
    public boolean isNStraightHand(int[] hand, int W) {
        int length = hand.length;
        if (W < 1) {
            return false;
        }
        if (W == 1) {
            return true;
        }
        if (length % W != 0) {
            return false;
        }
        Arrays.sort(hand);
        List<Integer> list = new ArrayList<>();
        for (int i : hand) {
            list.add(i);
        }
        //然后找连续数字拿完从集合中剔除。
        while (list.size() > 0) {
            Integer a = list.get(0);
            for (int k = 0; k < W; k++) {
                int i = list.indexOf(a + k);
                if (i == -1) {
                    return false;
                }
                list.remove(i);
            }
        }
        return true;
    }
}