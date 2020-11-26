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
        System.out.println(new Solution().minAddToMakeValid2("())"));
    }

    public int minAddToMakeValid2(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < S.length(); i++) {
            right += S.charAt(i) == '(' ? 1 : -1;
            if (right == -1) {
                left++;
                right++;
            }
        }
        return left + right;
    }

    public int minAddToMakeValid1(String S) {
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
