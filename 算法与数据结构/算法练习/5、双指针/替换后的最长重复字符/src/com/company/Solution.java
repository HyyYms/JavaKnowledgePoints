package com.company;

/**
 * @program: 替换后的最长重复字符
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-17 23:09
 **/
public class Solution {

    // 滑动窗口
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int historyCharMax = 0;
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        for (right = 0; right < chars.length; right++) {
            // 当前右窗口对应得字符
            int index = chars[right] - 'A';
            // 窗口内该字符增加
            map[index]++;
            // 窗口内元素最长的长度
            historyCharMax = Math.max(historyCharMax, map[index]);
            // 需要替换的字符个数
            // 就是当前窗口的大小减去窗口中数量最多的字符的数量
            if (right - left + 1 > historyCharMax + k) {
                // 缩减窗口
                map[chars[left] - 'A']--;
                // 窗口右移
                left++;
            }
        }
        return chars.length - left;
    }
}
