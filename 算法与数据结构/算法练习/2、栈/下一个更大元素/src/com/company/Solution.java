package com.company;

import java.util.HashMap;

import java.util.Arrays;

import java.util.LinkedList;

/**
 * @program: 下一个更大元素
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-20 21:35
 **/
public class Solution {

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();

        for (Integer i : nums1) {
            stack1.push(i);
        }
        int[] result = new int[nums1.length];
        for (int i = nums1.length - 1; i >= 0; i--) {
            int num = -1;
            for (Integer j : nums2) {
                stack2.push(j);
            }
            while (!stack2.isEmpty()) {
                Integer num1 = stack1.peek();
                Integer num2 = stack2.pop();
                if (num2 > num1) {
                    num = num2;
                }
                if (num1.equals(num2)) {
                    result[i] = num;
                    stack1.pop();
                    break;
                }
            }
            while (!stack2.isEmpty()) {
                stack2.pop();
            }
        }
        return result;
    }
}
