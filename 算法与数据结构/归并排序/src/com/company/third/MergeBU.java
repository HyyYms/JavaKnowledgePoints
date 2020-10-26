package com.company.third;

/**
 * @program: 归并排序
 * @description: 自底向上的归并排序算法
 * @author: Mr.Huang
 * @create: 2020-10-26 15:49
 **/
public class MergeBU {

    // 归并所需的辅助数组
    private static Comparable[] aux;

    public static void sort(Comparable[] arr) {
        // 进行lgN次两两归并
        int n = arr.length;
        aux = new Comparable[n];
        // sz:子数组大小
        for (int sz = 1; sz < n; sz = sz + sz) {
            // lo:子数组索引
            for (int lo = 0; lo < n - sz; lo += sz + sz) {
                merge(arr, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
            }
        }
    }

    private static void merge(Comparable[] arr, int lo, int mid, int hi) {
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
