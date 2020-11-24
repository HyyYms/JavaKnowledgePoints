package com.company;

import java.util.HashMap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: 下一个更大元素
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-24 15:26
 **/
public class Soluiton2 {

    public int[] nextGreaterElements2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }

    public int[] nextGreaterElements1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > num) {
                    map.put(i, j);
                    break;
                }
            }
            if (!map.containsKey(i)) {
                for (int k = 0; k < i; k++) {
                    if (nums[k] > num) {
                        map.put(i, k);
                        break;
                    }
                }
            }
            if (!map.containsKey(i)) {
                map.put(i, -1);
            }
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = map.get(i) == -1 ? -1 : nums[map.get(i)];
        }
        return result;
    }
}
