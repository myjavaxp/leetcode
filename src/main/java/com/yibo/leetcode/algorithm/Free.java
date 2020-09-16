package com.yibo.leetcode.algorithm;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Free {
    public static void main(String[] args) {
        new Free().free(new BigDecimal("1.03"), new BigDecimal(20), 50, new BigDecimal("1.05"), new BigDecimal(1000));
    }

    public BigDecimal free(BigDecimal bankRate, BigDecimal yearCost, int n, BigDecimal costRate, BigDecimal leftMoney) {
        for (int i = 0; i < n; i++) {
            System.out.println("------第" + (n - i) + "年------");
            System.out.println("本年度结余: " + leftMoney);
            BigDecimal lastYearCost = yearCost.multiply(costRate.pow(n - i - 1));
            leftMoney = leftMoney.divide(bankRate, RoundingMode.UP);
            leftMoney = leftMoney.add(lastYearCost);
            System.out.println("年初金钱: " + leftMoney);
            System.out.println("年度消费: " + lastYearCost);
            System.out.println("年度利息: " + leftMoney.multiply(bankRate.add(new BigDecimal(-1))));
            System.out.println("-------------------");
        }
        return leftMoney;
    }
}
