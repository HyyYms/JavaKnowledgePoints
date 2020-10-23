package com.company;

import com.company.util.SortUtil;

/**
 * @program: 选择排序
 * @description: 选择排序
 * @author: Mr.Huang
 * @create: 2020-10-23 20:05
 **/
public class Selection {

    public static void sort(Comparable[] arr) {
        // 数组长度
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 最小元素的索引
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (SortUtil.less(arr[j], arr[min])) {
                    min = j;
                }
                SortUtil.exch(arr, i, min);
            }
        }
    }
}
