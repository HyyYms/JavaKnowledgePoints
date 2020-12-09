package com.company;

/**
 * @program: 45、把数组排成最小的数
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-09 10:38
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().minNumber(new int[]{
                3, 30, 34, 5, 9
        });
    }

    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "0";
        }
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        quickSort(str);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }

    private void quickSort(String[] str) {
        if (str == null || str.length == 0) {
            return;
        }
        sort(str, 0, str.length - 1);
    }

    private void sort(String[] str, int start, int end) {
        if (start >= end) {
            return;
        }
        String pivot = str[start];
        int left = start;
        int right = end;
        while (left <= right) {
            while (left <= right && (pivot + str[left]).compareTo(str[left] + pivot) > 0) {
                left++;
            }
            while (left <= right && (pivot + str[right]).compareTo(str[right] + pivot) < 0) {
                right--;
            }
            if (left <= right) {
                String temp = str[left];
                str[left] = str[right];
                str[right] = temp;
                left++;;
                right--;
            }
        }
        sort(str, start, right);
        sort(str, left, end);
    }
}
