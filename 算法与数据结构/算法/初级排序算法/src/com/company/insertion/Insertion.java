package com.company.insertion;

import com.company.util.SortUtil;

/**
 * @program: 排序算法
 * @description: 插入排序算法
 * @author: Mr.Huang
 * @create: 2020-10-23 21:11
 **/
public class Insertion {

    public static void sort(Comparable[] arr) {
        // 将arr[] 按升序排列
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            // 将arr[i]插入到arr[i-1]、arr[i-2]、arr[i-3]...之中
            for (int j = i; j > 0 && SortUtil.less(arr[j], arr[j - 1]); j--) {
                SortUtil.exch(arr, j, j - 1);
            }
        }
    }
}
