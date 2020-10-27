package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @program: 快速排序
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-27 09:14
 **/
public class Quick {

    public static void sort(Comparable[] arr) {

        // 打乱数组的顺序
        Random rand = new Random(47);
        List list = Arrays.asList(arr);
        Collections.shuffle(list, rand);
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }

    private static int partition(Comparable[] arr, int lo, int hi) {
        // 将数组切分成arr[lo...i-1]，a[i],a[i+1...hi]
        // 左右扫描指针
        int i = lo, j = hi + 1;
        // 切分元素
        Comparable v = arr[lo];
        while (true) {
            while (SortUtil.less(arr[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (SortUtil.less(v, arr[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
        }
        SortUtil.exch(arr, lo, j);
        return j;
    }
}
