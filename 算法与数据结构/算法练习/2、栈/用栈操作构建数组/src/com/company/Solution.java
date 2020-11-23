package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: 用栈操作构建数组
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-23 15:36
 **/
public class Solution {

    public static void main(String[] args) {
        int[] target = new int[]{
                1, 3
        };
        new Solution().buildArray(target, 3);
    }

    public List<String> buildArray(int[] target, int n) {
        LinkedList<String> stack = new LinkedList<String>();
        int num = 0;
        for (int i = 1; i <= n; i++) {
            if (num == target.length) {
                break;
            }
            if (i < target[num]) {
                stack.push("Push");
                stack.push("Pop");
            } else if (i == target[num]) {
                stack.push("Push");
                num++;
            }
        }
        return stack;
    }
}
