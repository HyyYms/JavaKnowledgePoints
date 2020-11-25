package com.company;

import java.util.LinkedList;

/**
 * @program: 括号的分数
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-25 09:50
 **/
public class Solution {

    public int scoreOfParentheses(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }

        int result = 0;
        int level = 0;
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            char word = S.charAt(i);
            if (word == '(') {
                stack.push(word);
                level = stack.size();
            } else if (word == ')' && S.charAt(i - 1) == ')') {
                continue;
            } else {
                result += level == 1 ? 1 : Math.pow(2, level - 1);
            }
        }
        return result;
    }
}
