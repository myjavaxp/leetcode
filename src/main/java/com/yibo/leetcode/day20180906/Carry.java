package com.yibo.leetcode.day20180906;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Carry {
    /**
     * 给出最佳方案：最佳方案暂定为最短集合，即司机数最小。如果存在多个，则选择任意一个方案
     *
     * @param rules 数据库中取出相关规则
     * @param cars  用户输入的汽车类型。
     * @return 解决方案
     */
    public List<Solution> carry(Set<Solution> rules, List<String> cars) {
        List<Solution> result = new ArrayList<>();
        return result;
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
