package com.company;

import java.util.HashSet;
import java.util.Set;

import java.util.*;

/**
 * @program: 50、第一个只出现一次的字符
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-08 19:07
 **/
public class Solution {

    // 改用Boolean
    public char firstUniqChar2(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (map.containsKey(c)) {
                map.put(c, true);
            } else {
                map.put(c, false);
            }
        }
        char res = ' ';
        for (Character c : chars) {
            if (!map.get(c)) {
                return c;
            }
        }
        return res;
    }

    // 使用HashMap，数字递增判断数字
    public char firstUniqChar1(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        char res = ' ';
        for (Character c : chars) {
            if (map.get(c) == 1) {
                res = c;
                break;
            }
        }
        return res;
    }
}
