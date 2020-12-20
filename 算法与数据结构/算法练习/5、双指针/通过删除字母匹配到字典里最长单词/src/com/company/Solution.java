package com.company;

import java.util.List;

/**
 * @program: 通过删除字母匹配到字典里最长单词
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-20 21:43
 **/
public class Solution {

    public String findLongestWord(String s, List<String> d) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String res = "";
        for (String value : d) {
            if (isValid(s, value)) {
                if (value.length() > res.length() ||
                        (value.length() == res.length() && value.compareTo(res) < 0)) {
                    res = value;
                }
            }
        }
        return res;
    }

    private Boolean isValid(String s, String d) {
        int p1 = 0;
        int p2 = 0;
        for (p1 = 0; p1 < s.length() && p2 < d.length(); p1++) {
            if (s.charAt(p1) == d.charAt(p2)) {
                p2++;
            }
        }
        return p2 == d.length();
    }
}
