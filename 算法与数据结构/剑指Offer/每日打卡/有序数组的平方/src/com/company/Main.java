package com.company;
//给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
//
//         
//
//        示例 1：
//
//        输入：[-4,-1,0,3,10]
//        输出：[0,1,9,16,100]
//        示例 2：
//
//        输入：[-7,-3,2,3,11]
//        输出：[4,9,9,49,121]
//         
//
//        提示：
//
//        1 <= A.length <= 10000
//        -10000 <= A[i] <= 10000

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] A = new int[]{-4, -1, 0, 3, 10};
        sortedSquares1(A);
        System.out.println(A.toString());
    }

    public static int[] mysortedSquares(int[] A) {
        List<Integer> list = new ArrayList<>();
        int flag = 0;
        if (A == null || A.length == 0) {
            return A;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                flag = i;
                break;
            }
        }
        int before = flag - 1;
        int after = flag;
        while (after <= A.length - 1 && before >= 0) {
            if ((A[before] * A[before]) < (A[after] * A[after])) {
                list.add((A[before] * A[before]));
                before = before - 1;
            } else {
                list.add((A[after] * A[after]));
                after = after + 1;
            }
        }
        if (after == A.length) {
            while (before != -1) {
                list.add((A[before] * A[before]));
                before = before - 1;
            }
        } else if (before == -1) {
            while (after != A.length) {
                list.add((A[after] * A[after]));
                after = after + 1;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            A[i] = list.get(i);
        }
        return A;
    }

    public static int[] sortedSquares1(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
            if (A[i] * A[i] > A[j] * A[j]) {
                ans[pos] = A[i] * A[i];
                ++i;
            } else {
                ans[pos] = A[j] * A[j];
                --j;
            }
            --pos;
        }
        return ans;
    }

    public int[] sortedSquares2(int[] A) {
        int n = A.length;
        int negative = -1;
        for (int i = 0; i < n; ++i) {
            if (A[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] ans = new int[n];
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                ans[index] = A[j] * A[j];
                ++j;
            } else if (j == n) {
                ans[index] = A[i] * A[i];
                --i;
            } else if (A[i] * A[i] < A[j] * A[j]) {
                ans[index] = A[i] * A[i];
                --i;
            } else {
                ans[index] = A[j] * A[j];
                ++j;
            }
            ++index;
        }

        return ans;
    }

    public int[] sortedSquares3(int[] A) {
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            ans[i] = A[i] * A[i];
        }
        Arrays.sort(ans);
        return ans;
    }
}
