package com.company.second;

/**
 * @program: 归并排序
 * @description: 自顶向下的归并排序算法
 * @author: Mr.Huang
 * @create: 2020-10-26 11:14
 **/
public class Merge {

    // 归并所需的辅助数组
    private static Comparable[] aux;

    public static void sort(Comparable[] arr) {
        aux = new Comparable[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    public static void merge(Comparable[] arr, int lo, int mid, int hi) {
        // 将arr[lo...mid]和a[mid+1...hi]归并
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = aux[j++];
            } else if (j > hi) {
                arr[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                arr[k] = aux[j++];
            } else {
                arr[k] = aux[i++];
            }
        }
    }

    // 对元素进行比较
    private static boolean less(Comparable v, Comparable w) {
        // 返回-1/0/1：表示v小于/等于/大于w
        return v.compareTo(w) < 0;
    }
}
