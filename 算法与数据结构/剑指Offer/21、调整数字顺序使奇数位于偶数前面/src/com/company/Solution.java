package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: 21、调整数字顺序使奇数位于偶数前面
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-28 15:37
 **/
public class Solution {

    // 双指针
    public int[] exchange2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 0 && nums[right] % 2 != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            if (nums[left] % 2 != 0) {
                left++;
            }
            if (nums[right] % 2 == 0) {
                right--;
            }
        }
        return nums;
    }

    // 创建list进行存储
    public int[] exchange1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                list2.add(num);
            } else {
                list1.add(num);
            }
        }

        list1.addAll(list2);
        int[] result = new int[nums.length];
        for (int i = 0; i < list1.size(); i++) {
            result[i] = list1.get(i);
        }
        return result;
    }
}
