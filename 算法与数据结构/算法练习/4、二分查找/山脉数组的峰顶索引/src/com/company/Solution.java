package com.company;

/**
 * @program: 山脉数组的峰顶索引
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-11 20:50
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().peakIndexInMountainArray(new int[]{3, 5, 3, 2, 0});
    }

    public int peakIndexInMountainArray(int[] arr) {
        int mid;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
            } else if (arr[mid] >= arr[mid + 1]) {
                end = mid - 1;
            } else if (arr[mid] <= arr[mid + 1]) {
                start = mid + 1;
            }
        }
        return start;
    }

}
