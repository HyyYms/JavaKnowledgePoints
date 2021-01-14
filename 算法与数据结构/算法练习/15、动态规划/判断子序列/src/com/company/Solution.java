package com.company;

/**
 * @program: 判断子序列
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-12 13:44
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().isSubsequence("", "ahbgdc");
    }

    public boolean isSubsequence(String s, String t) {
        int m = s.length() + 1;
        int n = t.length() + 1;
        boolean[][] arr = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            arr[0][i] = true;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1];
                } else {
                    arr[i][j] = arr[i][j-1];
                }
            }
        }
        return arr[m - 1][n - 1];
    }
}
