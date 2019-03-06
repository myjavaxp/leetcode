package com.yibo.leetcode.eight;

import com.yibo.leetcode.eight.domain.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AppleUtil {
    private static final String[] COLORS = {"green", "red", "blue", "yellow", "white"};

    public static List<Apple> generateAppleList() {
        List<Apple> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int index = random.nextInt(5);
            list.add(new Apple(COLORS[index], random.nextInt(1000) + 1));
        }
        return list;
    }
}