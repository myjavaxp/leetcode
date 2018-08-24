package com.yibo.leetcode.history;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * <p>
 * 示例:
 * <p>
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 说明:
 * <p>
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 */
public class IncreaseSequence {
    public List<List<Integer>> findSubsequences(int[] nums) {
/*        if (null == nums || nums.length < 2) {
            throw new RuntimeException("输入数组长度至少为2");
        }*/
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 2; i <= nums.length; i++) {
            //依次获取长度为2~nums.length的子集。
            List<List<Integer>> subList = getSubList(nums.length, i);
            for (List<Integer> list1 : subList) {
                List<Integer> list2 = new ArrayList<>();
                for (int n : list1) {
                    list2.add(nums[n]);
                }
                if (isIncr(list2) && add(list, list2)) {
                    list.add(list2);
                }
            }
        }
        return list;
    }

    //判断是否可以添加
    private boolean add(List<List<Integer>> list1, List<Integer> list2) {
        for (List<Integer> list : list1) {
            if (compare(list, list2)) {//如果两个相等。则不能添加
                return false;
            }
        }
        return true;
    }

    //判断是否递增
    private boolean isIncr(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    //比较两个排序后的数组是否一样。
    private boolean compare(List<Integer> list1, List<Integer> list2) {
        if (null == list1 || null == list2) {
            return false;
        }
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    //k获取k长度的子集
    private List<List<Integer>> getSubList(int length, int k) {
/*        if (length < 2) {
            throw new RuntimeException("输入数组长度至少为2");
        }
        if (k < 1 || k > length) {
            throw new RuntimeException("子集长度必须大于0并且小于等于父集合长度");
        }*/
        if (k == 1) {
            List<List<Integer>> subLists = new ArrayList<>();
            //数组下标
            for (int i = 0; i < length; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                subLists.add(list);
            }
            return subLists;
        }
        List<List<Integer>> subList = getSubList(length, k - 1);
        //通过k-1来拿K
        List<List<Integer>> kList = new ArrayList<>();
        for (List<Integer> list : subList) {
            List<List<Integer>> kList1 = getKList(length, list);
            if (kList1 != null) {
                kList.addAll(kList1);
            }
        }
        return kList;
    }

    //拿到k长度的数组，传入的list长度为k-1
    private List<List<Integer>> getKList(int length, List<Integer> list) {
        Integer lastIndex = list.get(list.size() - 1);
        if (length - 1 == lastIndex) {
            return null;
        }
        List<List<Integer>> kList = new ArrayList<>();
        for (int i = lastIndex + 1; i < length; i++) {
            List<Integer> list1 = new ArrayList<>(list);
            list1.add(i);
            kList.add(list1);
        }
        return kList;
    }
}