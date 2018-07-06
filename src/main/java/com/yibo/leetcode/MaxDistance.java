package com.yibo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
 *
 * 至少有一个空座位，且至少有一人坐在座位上。
 *
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 *
 * 返回他到离他最近的人的【最大距离】。
 *
 * 示例 1：
 *
 * 输入：[1,0,0,0,1,0,1]
 * 输出：2
 * 解释：
 * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
 * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
 * 因此，他到离他最近的人的最大距离是 2 。
 * 示例 2：
 *
 * 输入：[1,0,0,0]
 * 输出：3
 * 解释：
 * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
 * 这是可能的最大距离，所以答案是 3 。
 * 提示：
 *
 * 1 <= seats.length <= 20000
 * seats 中只含有 0 和 1，至少有一个 0，且至少有一个 1。
 *
 */
public class MaxDistance {
    public static int maxDistToClosest(int[] seats) {
        if (null == seats || seats.length < 2) {
            throw new RuntimeException("输入数组长度至少为2");
        }
        int length=seats.length;
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <length ; i++) {
            if(seats[i]==1){
                list.add(i);
            }
        }
        //最大距离
        int distance=0;
        for(int i=0;i<list.size()-1;i++){
            int k=(list.get(i+1)-list.get(i))/2;
            if(k>distance){
                distance=k;
            }
        }
        if(list.get(0)>distance){
            distance=list.get(0);
        }
        if((length-1)-list.get(list.size()-1)>distance){
            return (length-1)-list.get(list.size()-1);
        }
        return distance;
    }
}