package com.company;

/**
 * @program: 归并排序
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-26 11:14
 **/
public class Merge {

    public static void merge(Comparable[] arr, int lo, int mid, int hi) {
        // 将arr[lo...mid]和a[mid+1...hi]归并
        int i = lo;
        int j = mid + 1;
        Comparable[] aux = new Comparable[arr.length];
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
