package com.company;

import java.util.LinkedList;

/**
 * @program: 删除最外层的括号
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-23 11:31
 **/
public class Solution3 {

    public static void main(String[] args) {
        new Solution3().removeDuplicates("abbaca");
    }

    public String removeDuplicates(String S) {
        if (S == null) {
            return null;
        }
        LinkedList<Character> stack = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        char[] chars = S.toCharArray();
        sb.append(chars[0]);
        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (!stack.isEmpty() && chars[i] == stack.peek() ) {
                stack.pop();
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(chars[i]);
                stack.push(chars[i]);
            }
        }
        return sb.toString();
    }
}
