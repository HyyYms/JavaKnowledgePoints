package com.company;

import java.util.*;


import java.util.Arrays;

/**
 * @program: 40、最小的K个数
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-03 08:40
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().getLeastNumbers2(new int[]{3, 2, 1}, 2);
    }

    public int[] getLeastNumbers3(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[]{};
        }
        sort(arr, 0, arr.length - 1, k);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    private void sort(int[] arr, int start, int end, int k) {
        if (start >= end || start >= k) {
            return;
        }
        int pivot = arr[start];
        int left = start;
        int right = end;
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
        sort(arr, start, right, k);
        sort(arr, left, end, k);
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return null;
        }
        Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int value : arr) {
            if (queue.size() < k) {
                queue.offer(value);
            } else if (queue.size() == k) {
                if (value < queue.peek()) {
                    queue.poll();
                    queue.offer(value);
                }
            }
        }
        int[] result = new int[k];
        int i = 0;
        for (Integer value : queue) {
            result[i++] = value;
        }
        return result;
    }

    public int[] getLeastNumbers1(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[]{};
        }
        Arrays.sort(arr);
        int[] result = new int[k];
        System.arraycopy(arr, 0, result, 0, k);
        return result;
    }
}
