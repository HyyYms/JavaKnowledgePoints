package com.company;

import java.util.HashMap;

/**
 * @program: 39、数组中出现次数超过一半的数字
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-28 17:33
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().majorityElement1(
                new int[]{
                        1, 2, 3, 2, 2, 2, 5, 4, 2
                }
        );
    }

    public int majorityElement2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int sum = 0;
        int k = 0;
        for (int num : nums) {
            if (sum == 0) {
                k = num;
            }
            sum += k == num ? 1 : -1;
        }
        return k;
    }

    public int majorityElement1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            if (map.get(num) > (nums.length / 2)) {
                return num;
            }
        }
        return -1;
    }
}
