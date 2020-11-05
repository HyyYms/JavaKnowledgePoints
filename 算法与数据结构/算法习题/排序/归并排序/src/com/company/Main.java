package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }

    private static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSortImpl(arr, 0, arr.length - 1, temp);
    }

    private static void mergeSortImpl(int[] arr, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSortImpl(arr, start, mid, temp);
        mergeSortImpl(arr, mid + 1, end, temp);
        merge(arr, start, mid, end, temp);
    }

    private static void merge(int[] arr, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid + 1;
        int index = start;
        while (left <= mid && right <= end) {
            if (arr[left] < arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = arr[left++];
        }
        while (right <= end) {
            temp[index++] = arr[right++];
        }
        for (index = start; index <= end; index++) {
            arr[index] = temp[index];
        }
    }
}
