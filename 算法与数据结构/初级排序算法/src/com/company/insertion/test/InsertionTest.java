package com.company.insertion.test;

import com.company.insertion.Insertion;
import com.company.selection.Selection;

/**
 * @program: 排序算法
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-23 21:31
 **/
public class InsertionTest {

    public static void main(String[] args) {
        // 空数组测试
        emptyTest();
        // 无序数组测试
        disorderTest();
        // 有序数组测试
        orderTest();
        // 部分有序数组测试
        partiallyOrderedTest();
    }

    // 空数组
    private static void emptyTest() {
        String[] arr = new String[0];
        Insertion.sort(arr);
    }

    // 无序数组
    private static void disorderTest() {
        String[] arr = new String[]{
                "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"
        };
        Insertion.sort(arr);
    }

    // 有序数组
    private static void orderTest() {
        String[] arr = new String[]{
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"
        };
        Insertion.sort(arr);
    }

    // 部分有序的数组
    private static void partiallyOrderedTest(){
        String[] arr = new String[]{
                "E", "X", "A", "M", "P", "L", "E"
        };
        Insertion.sort(arr);
    }
}
