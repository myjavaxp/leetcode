package com.yibo.leetcode.history;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/submissions/detail/4048467/
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        List<Character> list=new ArrayList<>();
        for(char c:chars){
           list.add(c);
        }
        for(int i=0;i<chars.length;i++){
            final int x=i;
            long count = list.stream().filter(a -> a == chars[x]).count();
            if(count==1){
                return i;
            }
        }
        return -1;
    }
}