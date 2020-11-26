package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: 删除字符串中的所有相邻重复项
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-26 11:19
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates2("abbbaacc",
                3));
    }


    // 判断栈顶元素出现的次数，并及时删减String，以及调整指针指向位置
    public String removeDuplicates2(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuffer sb = new StringBuffer(s);
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < sb.length(); i++) {
            if (i > 0) {
                if (sb.charAt(i - 1) == sb.charAt(i)) {
                    stack.push(stack.pop() + 1);
                } else {
                    stack.push(1);
                }
                if (!stack.isEmpty() && stack.peek() == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                    stack.pop();
                }
            } else {
                stack.push(1);
            }
        }
        return sb.toString();
    }

    // 时间效率过低，不可使用
    public String removeDuplicates1(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);
            boolean insert = true;
            if (stack.size() >= k - 1) {
                boolean delete = true;
                LinkedList<Character> list = new LinkedList<>();
                for (int j = 0; j < k - 1; j++) {
                    if (stack.peek() != word) {
                        delete = false;
                        break;
                    }
                    list.push(stack.pop());
                }
                if (delete) {
                    while (!list.isEmpty()) {
                        list.pop();
                    }
                    insert = false;
                } else {
                    while (!list.isEmpty()) {
                        stack.push(list.pop());
                    }
                }
            }
            if (insert) {
                stack.push(word);
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
