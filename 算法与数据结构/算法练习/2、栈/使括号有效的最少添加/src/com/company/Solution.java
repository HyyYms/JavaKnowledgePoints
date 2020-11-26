package com.company;

import java.util.LinkedList;

/**
 * @program: 使括号有效的最少添加
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-26 10:40
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().minAddToMakeValid("())"));
    }

    public int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            char word = S.charAt(i);
            if (word == '(') {
                stack.push(word);
            } else if (word == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(word);
            }
        }
        return stack.size();
    }
}
