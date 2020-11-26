package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: 基本计算器
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-25 16:33
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().calculate("2-1 + 2 "));
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        return calculateHelp(list);
    }

    public int calculateHelp(List<Character> list) {
        char sign = '+';
        int num = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        while (!list.isEmpty()) {
            char c = list.remove(0);
            boolean isNum = isNumber(c);
            if (isNum) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                num = calculateHelp(list);
            }
            if ((c != ' ' && !isNum) || 0 == list.size()) {
                switch (sign) {
                    case '+':
                        num = +num;
                        break;
                    case '-':
                        num = -num;
                        break;
                    case '*':
                        num = stack.pop() * num;
                        break;
                    case '/':
                        num = stack.pop() / num;
                        break;
                }
                stack.push(num);
                sign = c;
                num = 0;
            }
            if (c == ')') {
                break;
            }
        }
        int result = 0;
        while (stack.peek() != null) {
            result += stack.pop();
        }
        return result;
    }

    private boolean isNumber(Character c) {
        for (int i = 0; i < 10; i++) {
            if ((c - '0') == i) {
                return true;
            }
        }
        return false;
    }
}
