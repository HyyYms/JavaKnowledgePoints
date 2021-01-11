package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: 矩阵中战斗力最弱的 K 行
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-11 16:59
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().kWeakestRows(new int[][]{
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1}},
                3);
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int temp = searchOne(mat[i]);
            list.add(temp * 100 + i);
        }
        Collections.sort(list);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i) % 100;
        }
        return res;
    }

    private int searchOne(int[] mat) {
        int mid;
        int start = 0;
        int end = mat.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (mat[mid] == 1) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        if (mat[end] == 1) {
            return end + 1;
        }
        if (mat[start] == 1) {
            return start + 1;
        }
        return start;
    }
}
