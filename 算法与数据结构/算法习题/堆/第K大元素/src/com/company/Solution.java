package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: 第K大元素
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-06 09:44
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().findKthLargest(new int[]{
                3, 2, 1, 5, 6, 4
        }, 3);
    }

    public int findKthLargestQuickSort(int[] nums, int k) {
        sort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = arr[start];
        while (left <= right) {
            while (left <= right && arr[left] < pivot) {
                left++;
            }
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        sort(arr, start, right);
        sort(arr, left, end);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            heap.poll();
        }
        return heap.peek();
    }
}
