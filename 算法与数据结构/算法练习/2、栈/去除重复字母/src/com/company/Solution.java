package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @program: 去除重复字母
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-24 10:46
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().removeDuplicateLetters("ecbacba");
    }

    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Deque<Character> stack = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character word = s.charAt(i);
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            Character word = s.charAt(i);
            if (!stack.contains(word)) {
                while (!stack.isEmpty() && stack.peekLast() > word && map.get(stack.peekLast()) > 1) {
                    map.put(stack.peekLast(), map.get(stack.pollLast()) - 1);
                }
                stack.offerLast(word);
            } else {
                map.put(word, map.get(word) - 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
}
