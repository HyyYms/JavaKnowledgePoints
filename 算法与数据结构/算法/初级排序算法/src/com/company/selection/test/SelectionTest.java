package com.company.selection.test;

import com.company.selection.Selection;

/**
 * @program: 排序算法
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-23 20:26
 **/
public class SelectionTest {

    public static void main(String[] args) {
        // 空数组测试
        emptyTest();
        // 无序数组测试
        disorderTest();
        // 有序数组测试
        orderTest();
    }

    // 空数组
    private static void emptyTest() {
        String[] arr = new String[0];
        Selection.sort(arr);
    }

    // 无序数组
    private static void disorderTest() {
        String[] arr = new String[]{
                "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"
        };
        Selection.sort(arr);
    }

    // 有序数组
    private static void orderTest() {
        String[] arr = new String[]{
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"
        };
        Selection.sort(arr);
    }
}
