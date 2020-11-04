package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10000);
        }
        selectSort(array);
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j]);
        }
    }

    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private static void insertSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int j;
        for (int i = 1; i < arr.length; i++) {
            j = i - 1;
            int insertNode = arr[i];
            while (j >= 0 && arr[j] > insertNode) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = insertNode;
        }
    }

    private static void selectSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int pos;
        for (int i = 0; i < arr.length; i++) {
            pos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[pos]) {
                    pos = j;
                }
            }
            if (pos != i) {
                int temp = arr[i];
                arr[i] = arr[pos];
                arr[pos] = temp;
            }
        }
    }
}
