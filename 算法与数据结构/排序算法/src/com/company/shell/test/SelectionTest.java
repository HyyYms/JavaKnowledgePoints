package com.company.shell.test;

import com.company.selection.Selection;
import com.company.shell.Shell;

/**
 * @program: 排序算法
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-25 15:52
 **/
public class SelectionTest {

    public static void main(String[] args) {
        // 空数组测试
        emptyTest();
        // 非空数组测试
        test();
    }

    // 空数组
    private static void emptyTest() {
        String[] arr = new String[0];
        Shell.sort(arr);
    }

    // 非空数组
    private static void test() {
        String[] arr = new String[]{
                "S", "H", "E", "L", "L", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"
        };
        Selection.sort(arr);
    }
}
