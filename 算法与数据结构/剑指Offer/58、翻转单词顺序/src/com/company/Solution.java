package com.company;

/**
 * @program: 58、翻转单词顺序
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-05 11:38
 **/
public class Solution {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] s1 = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(s1[s1.length - 1]);
        for (int i = s1.length - 2; i >= 0; i--) {
            if (!"".equals(s1[i])) {
                sb.append(" ").append(s1[i]);
            }
        }
        return sb.toString();
    }
}
