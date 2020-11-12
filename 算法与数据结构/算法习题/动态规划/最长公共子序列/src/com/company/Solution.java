package com.company;

/**
 * @program: 最长公共子序列
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-12 21:19
 **/
public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int aLength = text1.length();
        int bLength = text2.length();
        int[][] result = new int[aLength + 1][bLength + 1];
        for (int i = 1; i <= aLength; i++) {
            for (int j = 1; j <= bLength; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
        return result[aLength][bLength];
    }
}
