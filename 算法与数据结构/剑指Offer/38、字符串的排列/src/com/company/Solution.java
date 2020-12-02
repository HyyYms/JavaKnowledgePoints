package com.company;

import java.util.*;

/**
 * @program: 38、字符串的排列
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-02 22:06
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(
                new Solution().permutation("abc"));
    }


    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[]{};
        }
        int x = 0;
        char[] chars = s.toCharArray();
        List<String> result = new ArrayList<>();
        dfs(x, chars, result);
        return result.toArray(new String[result.size()]);
    }

    private void dfs(int x, char[] chars, List<String> result) {
        if (x == chars.length - 1) {
            result.add(String.valueOf(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = x; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            swap(chars, i, x);
            dfs(x + 1, chars, result);
            swap(chars, i, x);
        }
    }

    private void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}
