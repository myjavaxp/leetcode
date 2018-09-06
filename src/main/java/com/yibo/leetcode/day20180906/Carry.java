package com.yibo.leetcode.day20180906;

import java.util.*;

public class Carry {
    /**
     * 给出最佳方案：最佳方案暂定为最短集合，即司机数最小。如果存在多个，则选择任意一个方案
     *
     * @param rules 数据库中取出相关规则
     * @param cars  用户输入的汽车类型。
     * @return 解决方案
     */
    public List<Solution> carry(List<Solution> rules, List<String> cars) {
        Set<Solution> ruleSet = new HashSet<>(rules);
        Map<String, Integer> carMap = new HashMap<>();
        List<Solution> result = new ArrayList<>();
        for (String car : cars) {
            carMap.merge(car, 1, (a, b) -> a + b);
        }
        //规则清洗
        for (Solution solution : ruleSet) {
            if (!isValid(solution, carMap)) {
                ruleSet.remove(solution);
            }
        }
        return result;
    }

    private boolean isValid(Solution solution, Map<String, Integer> map) {
        if (solution.bottom == null) {
            return false;
        }
        return map.containsKey(solution.bottom) &&
                (solution.middle == null || map.containsKey(solution.middle)) &&
                (solution.middle == null || map.containsKey(solution.middle));
    }

    /**
     * 解决方案
     */
    private class Solution {
        private String bottom;
        private String middle;
        private String top;

        private Solution(String bottom, String middle, String top) {
            this.bottom = bottom;
            this.middle = middle;
            this.top = top;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Solution solution = (Solution) o;
            return Objects.equals(bottom, solution.bottom) &&
                    Objects.equals(middle, solution.middle) &&
                    Objects.equals(top, solution.top);
        }

        @Override
        public int hashCode() {
            return Objects.hash(bottom, middle, top);
        }
    }
}
