package com.company.shell;

import com.company.util.SortUtil;

/**
 * @program: 排序算法
 * @description: 希尔排序算法
 * @author: Mr.Huang
 * @create: 2020-10-25 15:42
 **/
public class Shell {

    public static void sort(Comparable[] arr) {
        // 将a[]按升序排列
        int n = arr.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                // 将a[i]插入到a[i-h],a[i-2*h],a[i-3*h]...之中
                for (int j = i; j >= h && SortUtil.less(arr[j], arr[j - h]); j -= h) {
                    SortUtil.exch(arr, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
