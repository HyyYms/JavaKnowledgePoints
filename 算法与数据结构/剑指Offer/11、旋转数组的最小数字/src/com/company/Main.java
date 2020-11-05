package com.company;

public class Main {

    public static void main(String[] args) {
        int[] minArray = new int[]{
                3, 4, 5, 1, 2
        };
        System.out.println(minArray(minArray));
    }

    public static int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            // 防止溢出
            int mid = low + (high - low) / 2;
            if (numbers[mid] < numbers[high]) {
                high = mid;
            } else if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}
