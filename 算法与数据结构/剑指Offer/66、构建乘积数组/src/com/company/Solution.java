package com.company;

/**
 * @program: 66、构建乘积数组
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-04 13:17
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().constructArr2(new int[]{
                1, 2, 3, 4, 5
        });
    }

    // n
    public int[] constructArr2(int[] a) {
        if (a == null || a.length == 0) {
            return new int[]{};
        }
        int[] res = new int[a.length];
        res[0] = 1;
        int temp = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }
        for (int i = res.length - 2; i >= 0; i--) {
            temp = temp * a[i + 1];
            res[i] = res[i] * temp;
        }
        return res;
    }

    // 超出时间限制 n^2
    public int[] constructArr1(int[] a) {
        if (a == null || a.length == 0) {
            return new int[]{};
        }
        int[] res = new int[a.length];
        for (int i = 0; i < res.length; i++) {
            int num = 1;
            for (int j = 0; j < res.length; j++) {
                if (j != i) {
                    num = num * a[j];
                }
            }
            res[i] = num;
        }
        return res;
    }
}
