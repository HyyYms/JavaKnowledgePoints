package com.company;

import java.util.LinkedList;

/**
 * @program: 比较含退格的字符串
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-22 19:36
 **/
public class Solution {
    
    public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) {
            return false;
        }
        return deleteWord(S).equals(deleteWord(T));
    }

    private String deleteWord(String str) {
        if (str == null) {
            return null;
        }
        StringBuffer result = new StringBuffer();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (aChar != '#') {
                result.append(aChar);
            } else {
                if (result.length() >= 1) {
                    result.deleteCharAt(result.length() - 1);
                }
            }
        }

        return result.toString();
    }
}
