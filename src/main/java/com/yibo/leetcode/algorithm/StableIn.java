package com.yibo.leetcode.algorithm;

import java.util.Arrays;
import java.util.Random;

public class StableIn {
    private static final Random RANDOM = new Random();

    /**
     * @param days     投资总天数
     * @param start    初始资金
     * @param dayMoney 定投金额
     * @return 投资结束的金额
     */
    public double[] getMoney(int days, double start, double dayMoney) {
        double cur1 = start;//定投
        double cur2 = start + dayMoney * days;//一次性把钱都投资进去
        double cur3 = start;
        int index = -1;
        for (int i = 0; i < days; i++) {
            double p = (RANDOM.nextDouble() * 2 - 1) / 10;//范围是从-10%~10% 随机浮动，当天利率
            cur1 = cur1 * (1 + p) + dayMoney;
            cur2 = cur2 * (1 + p);
            cur3 = cur3 * (1 + p);
            if (p < 0) {
                cur3 = cur3 + dayMoney * (i - index);
                index = i;
            }
        }
        cur3 = cur3 + dayMoney * (days - 1 - index);
        return new double[]{cur1, cur2, cur3};
    }

    public static void main(String[] args) {
        int flag1 = 0;
        int flag2 = 0;
        int flag3 = 0;
        int flag4 = 0;
        int flag5 = 0;
        StableIn stableIn = new StableIn();
        for (int i = 0; i < 10000; i++) {
            //初始资金1万，每天定投100，连续投100天
            double[] money = stableIn.getMoney(100, 10000, 100);
            if (money[0] > money[1]) {
                flag1++;
            }
            if (money[2] > money[1]) {
                flag2++;
            }
            if (money[2] > money[0]) {
                flag3++;
            }
            if (money[1] < 10000) {
                flag5++;
                System.out.println(Arrays.toString(money));
                if (money[1] > money[0]) {
                    flag4++;
                }
            }
        }
        System.out.println("定投比一次性投资多的次数：" + flag1);
        System.out.println("智能定投比一次性投资多的次数：" + flag2);
        System.out.println("智能定投比定投多的次数：" + flag3);
        System.out.println("亏钱" + flag5 + "次的情况下，定投更傻逼的次数: " + flag4);
    }
}
