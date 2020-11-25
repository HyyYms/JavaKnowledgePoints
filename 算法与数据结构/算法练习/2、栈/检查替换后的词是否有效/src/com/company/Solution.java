package com.company;

import java.util.LinkedList;

/**
 * @program: 检查替换后的词是否有效
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-24 17:22
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().isValid12("aabcbc");
    }

    public boolean isValid12(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b') {
                    return false;
                }
                if (stack.isEmpty() || stack.pop() != 'a') {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid1(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        String abc = s.replaceAll("abc", "");
        return "".equals(abc);
    }
}
