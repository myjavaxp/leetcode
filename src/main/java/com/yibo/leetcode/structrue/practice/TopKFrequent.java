package com.yibo.leetcode.structrue.practice;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * https://leetcode-cn.com/problems/top-k-frequent-elements/description/
 */
public class TopKFrequent {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, (a, b) -> a + b);
        }
        /*
         * java自带的PriorityQueue是最小堆
         */
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(key) > map.get(queue.peek())) {
                queue.poll();
                queue.add(key);
            }
        }
        List<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }
}
