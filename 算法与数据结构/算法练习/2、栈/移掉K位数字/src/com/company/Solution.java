package com.company;

import java.util.Deque;

import java.util.LinkedList;

/**
 * @program: 移掉K位数字
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-23 22:16
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().removeKdigits("9", 1);
    }

    public String removeKdigits(String num, int k) {
        if (k == 0 || num == null || num.length() == 0) {
            return num;
        }

        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);
            while (k > 0 && !deque.isEmpty() && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }

        StringBuffer sb = new StringBuffer();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            Character digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
