package com.company;

/**
 * @program: 逆转单词
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-08 13:12
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords(" hello    world "));
    }

    public String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        // trim 去除前后空格
        String[] words = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!"".equals(words[i])) {
                sb.append(words[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
