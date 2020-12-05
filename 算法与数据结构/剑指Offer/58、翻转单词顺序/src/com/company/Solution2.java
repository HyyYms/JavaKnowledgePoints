package com.company;

/**
 * @program: 58、左旋转字符串
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-05 12:24
 **/
public class Solution2 {

    public String reverseLeftWords(String s, int n) {
        if (s == null || n == 0 || s.length() == 0) {
            return s;
        }
        return s.substring(n) + s.substring(0, n);
    }
}
