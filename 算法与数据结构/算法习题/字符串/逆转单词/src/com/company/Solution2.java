package com.company;

/**
 * @program: 逆转单词
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-08 13:32
 **/
public class Solution2 {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            words[i] = new StringBuilder(words[i]).reverse().toString();
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
