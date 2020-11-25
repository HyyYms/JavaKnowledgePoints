package com.company;

import java.util.LinkedList;

/**
 * @program: 反转每对括号间的子串
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-25 10:49
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().reverseParentheses("(ab(cd))");
    }

    public String reverseParentheses(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);
            if (word == '(') {
                stack.push(i);
            } else if (word == ')') {
                Integer pop = stack.pop();
                String reverseStr = new StringBuilder(s.substring(pop, i + 1))
                        .reverse().toString();
                s = s.substring(0, pop) + reverseStr + s.substring(i + 1);
            }
        }
        s = s.replace("(", "");
        s = s.replace(")", "");
        return s;
    }
}
