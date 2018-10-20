package com.yibo.leetcode.solution01;

/**
 * l=7
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 *       1,2,3,1,5,6,7
 * 输出: [5,6,7,1,2,3,4]
 */
public class Solution0189 {
    public void rotate(int[] nums, int k) {
        int l=nums.length;
        if(l<2){
            return;
        }
        k=k%l;
        if(k==0){
            return;
        }
        for(int i=0;i<l;i++){
            //nums[i]=nums[l-k-i];
            int temp=nums[i+k];
            nums[i+k]=nums[i];
        }
    }
}
