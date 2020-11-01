package com.company;

/**
 * @program: 两数之和—输入有序数组
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-29 22:37
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().twoSum(new int[]{
                -1, 0
        }, -1));
    }

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return numbers;
        }
        int start = 0;
        int end = numbers.length - 1;
        int[] result = {-1, -1};
        while (start + 1 < end) {
            if ((numbers[start] + numbers[end]) == target) {
                result[0] = start + 1;
                result[1] = end + 1;
                break;
            } else if ((numbers[start] + numbers[end]) > target) {
                end -= 1;
            } else {
                start += 1;
            }
        }
        return result;
    }
}
