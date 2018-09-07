package com.yibo.leetcode.day20180906;

import java.util.*;

public class Carry {
    public static void main(String[] args) {
        List<Solution> rules = new ArrayList<>();
        rules.add(new Solution(1L, 2L, 3L));
        rules.add(new Solution(1L, 4L, 3L));
        rules.add(new Solution(1L, 2L, null));
        rules.add(new Solution(1L, 4L, null));
        rules.add(new Solution(1L, 5L, 6L));
        rules.add(new Solution(1L, 5L, 6L));
        rules.add(new Solution(1L, 5L, 6L));
        rules.add(new Solution(1L, 5L, 6L));
        rules.add(new Solution(1L, 5L, 6L));
        rules.add(new Solution(1L, null, 6L));
        rules.add(new Solution(2L, 10L, 10L));
        List<Long> cars = new ArrayList<>();
        cars.add(1L);
        cars.add(2L);
        cars.add(1L);
        cars.add(2L);
        cars.add(3L);
        cars.add(1L);
        cars.add(1L);
        cars.add(5L);
        cars.add(6L);
        cars.add(6L);
        cars.add(6L);
        cars.add(6L);
        cars.add(4L);
        cars.add(10L);
        cars.add(10L);
        cars.add(10L);
        cars.add(1L);
        Carry carry = new Carry();
        List<Solution> solutions = carry.carry(rules, cars);
        solutions.forEach(System.out::println);
    }

    /**
     * 给出最佳方案：最佳方案暂定为最短集合，即司机数最小。如果存在多个，则选择任意一个方案
     *
     * @param rules 数据库中取出相关规则
     * @param cars  用户输入的汽车类型,可重复。
     * @return 解决方案
     */
    public List<Solution> carry(List<Solution> rules, List<Long> cars) {
        Map<Long, Integer> carMap = new HashMap<>();
        List<Solution> result = new ArrayList<>();
        for (Long car : cars) {
            carMap.merge(car, 1, (a, b) -> a + b);
        }
        Queue<Solution> queue = new PriorityQueue<>((o1, o2) -> o2.size() - o1.size());
        queue.addAll(rules);
        while (queue.size() > 0) {
            Solution solution = queue.peek();
            if (isValid(solution, carMap)) {
                result.add(solution);
                remove(solution, carMap);
            } else {
                queue.poll();
            }
        }
        Set<Long> keySet = carMap.keySet();
        for (Long car : keySet) {
            Integer i = carMap.get(car);
            for (int k = 0; k < i; k++) {
                result.add(new Solution(car));
            }
        }

        return result;
    }

    private void remove(Solution solution, Map<Long, Integer> map) {
        removeCar(solution.getBottom(), map);
        removeCar(solution.getMiddle(), map);
        removeCar(solution.getTop(), map);
    }

    private void removeCar(Long car, Map<Long, Integer> map) {
        if (car != null) {
            Integer i = map.get(car);
            if (i == null) {
                return;
            }
            if (i < 2) {
                map.remove(car);
            } else {
                map.put(car, i - 1);
            }
        }
    }

    private boolean isValid(Solution solution, Map<Long, Integer> map) {
        Long bottom = solution.getBottom();
        Long middle = solution.getMiddle();
        Long top = solution.getTop();
        if (bottom == null) {
            return false;
        }
        Map<Long, Integer> temp = new HashMap<>();
        temp.put(bottom, 1);
        if (middle != null) {
            if (middle.equals(bottom)) {
                temp.put(bottom, 2);
            } else {
                temp.put(middle, 1);
            }
        }
        if (top != null) {
            if (temp.containsKey(top)) {
                temp.put(top, temp.get(top) + 1);
            } else {
                temp.put(top, 1);
            }
        }
        if (!map.containsKey(bottom)) {
            return false;
        }
        return map.get(bottom) >= temp.get(bottom) &&
                (middle == null || (map.containsKey(middle) && map.get(middle) >= temp.get(middle))) &&
                (top == null || (map.containsKey(top) && map.get(top) >= temp.get(top)));
    }
}
