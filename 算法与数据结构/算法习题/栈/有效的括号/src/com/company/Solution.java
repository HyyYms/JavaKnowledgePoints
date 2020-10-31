package com.company;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: 有效的括号
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-27 11:07
 **/
public class Solution {

    public static void main(String[] args) {
        myIsValid("([)]");
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if (c == ')') {
                if (stack.pop() != '(' || stack.isEmpty()) {
                    return false;
                }
            }
            if (c == ']') {
                if (stack.pop() != '[' || stack.isEmpty()) {
                    return false;
                }
            }
            if (c == '}') {
                if (stack.pop() != '{' || stack.isEmpty()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean myIsValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (stack.size() == 0 || c == '(' || c == '[' || c == '{') {
                stack.push(c);
                list.add(c);
                System.out.println("栈：" + stack);
                System.out.println("链表：" + list);
                continue;
            }
            if (c == ')') {
                if ('(' == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(c);
                    list.add(c);
                    System.out.println("栈：" + stack);
                    System.out.println("链表：" + list);
                }
                continue;
            }
            if (c == ']') {
                if ('[' == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(c);
                    list.add(c);
                    System.out.println("栈：" + stack);
                    System.out.println("链表：" + list);
                }
                continue;
            }
            if (c == '}') {
                if ('{' == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(c);
                    list.add(c);
                    System.out.println("栈：" + stack);
                    System.out.println("链表：" + list);
                }
            }
        }
        return stack.size() <= 0;
    }
}
