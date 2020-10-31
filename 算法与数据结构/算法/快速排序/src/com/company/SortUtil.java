package com.company;

/**
 * @program: 选择排序
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-23 20:09
 **/
public class SortUtil {

    // 对元素进行比较
    public static boolean less(Comparable v, Comparable w) {
        // 返回-1/0/1：表示v小于/等于/大于w
        return v.compareTo(w) < 0;
    }

    // 将元素交换位置
    public static void exch(Comparable[] arr, int i, int j) {
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 展示数组
    public static void show(Comparable[] arr) {
        for (Comparable comparable : arr) {
            System.out.println(comparable + "");
        }
    }

    // 判断数组是否有序
    public static boolean isSorted(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i], arr[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
