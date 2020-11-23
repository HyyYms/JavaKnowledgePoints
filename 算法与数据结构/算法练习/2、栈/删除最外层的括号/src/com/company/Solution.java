package com.company;

import java.util.LinkedList;

/**
 * @program: 删除最外层的括号
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-23 10:33
 **/
public class Solution {

    public String removeOuterParentheses(String S) {
        if (S == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        LinkedList<Character> stack = new LinkedList<>();
        char[] chars = S.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(' && stack.isEmpty()) {
                stack.push(aChar);
            } else if (aChar == '(') {
                stack.push(aChar);
                sb.append("(");
            } else if (aChar == ')' && stack.size() == 1) {
                stack.pop();
            } else {
                stack.pop();
                sb.append(aChar);
            }
        }
        return sb.toString();
    }
}
