package com.yibo.leetcode.day20180906;

import java.util.Objects;
import java.util.StringJoiner;

public class Solution {
    private Long bottom;
    private Long middle;
    private Long top;

    public Solution(Long bottom, Long middle, Long top) {
        this.bottom = bottom;
        this.middle = middle;
        this.top = top;
    }

    public Solution(Long bottom) {
        this.bottom = bottom;
    }

    public int size() {
        int size = 0;
        if (bottom != null) {
            size++;
        }
        if (middle != null) {
            size++;
        }
        if (top != null) {
            size++;
        }
        return size;
    }

    public Long getBottom() {
        return bottom;
    }

    public void setBottom(Long bottom) {
        this.bottom = bottom;
    }

    public Long getMiddle() {
        return middle;
    }

    public void setMiddle(Long middle) {
        this.middle = middle;
    }

    public Long getTop() {
        return top;
    }

    public void setTop(Long top) {
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

    @Override
    public String toString() {
        return new StringJoiner(", ", Solution.class.getSimpleName() + "[", "]")
                .add("bottom=" + bottom)
                .add("middle=" + middle)
                .add("top=" + top)
                .toString();
    }
}
