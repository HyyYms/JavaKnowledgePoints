package com.company;

import java.util.LinkedList;

/**
 * @program: 整理字符串
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-23 10:55
 **/
public class Solution2 {

    public static void main(String[] args) {
        new Solution2().makeGood("abBAcC");
    }

    public String makeGood(String s) {
        if (s == null) {
            return null;
        }
        LinkedList<Character> stack = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        sb.append(chars[0]);
        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (!stack.isEmpty() && Math.abs(chars[i] - stack.peek()) == 32) {
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
