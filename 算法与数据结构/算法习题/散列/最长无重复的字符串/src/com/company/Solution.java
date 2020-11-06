package com.company;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: 最长无重复的字符串
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-06 22:05
 **/
public class Solution {

    public static void main(String[] args) {
        int length = new Solution().lengthOfLongestSubstring("abcbbcbb");
        System.out.println(length);
    }
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int right = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                max = Math.max(max, right - i);
            }
            set.remove(s.charAt(i));
        }
        return max;
    }
}
