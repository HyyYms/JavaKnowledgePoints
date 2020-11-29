package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * @program: 19、正则表达式匹配
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-28 22:47
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aaa", "a*a"));
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j == 0) {
                    // 空——空：[0][0]
                    // 非空——空：[i][0] （i > 0）
                    f[i][j] = i == 0;
                } else {
                    // p当前的字符不为*时
                    // i需大于0——s的字符为非空状态（i == 0 ：表示s的当前字符为空）
                    // s的当前字符需同p的当前字符相同或p的当前字符为.
                    // 若满足则判断前一字符是否匹配，若不匹配则该字符同样不匹配。
                    if (p.charAt(j - 1) != '*') {
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        // 当p的当前字符为*时
                        // 若*重复前一字符次数为0时；则只需看s的当前字符与p的前两个字符的匹配情况即[i][j-2]
                        // 若*重复前一字符次数为多次时；则需要s的当前字符与p的前一字符相同或p的前一字符为.
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }
}
