package com.company;

import java.util.LinkedList;

/**
 * @program: 31、栈的压入、弹出序列
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-28 15:20
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(
                new Solution().validateStackSequences(
                        new int[]{
                                2,1,0
                        },
                        new int[]{
                                1,2,0
                        })
        );
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (popped == null || popped.length == 0) {
            return true;
        }
        int k = 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int value : pushed) {
            stack.push(value);
            while (!stack.isEmpty() && stack.peek() == popped[k]) {
                stack.pop();
                k++;
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() != popped[k]) {
                return false;
            }
            k++;
            stack.pop();
        }
        return true;
    }
}
