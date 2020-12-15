package com.company;

/**
 * @program: 长键按入
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-15 11:09
 **/
public class Solution3 {

    public static void main(String[] args) {
        new Solution3().isLongPressedName("alex", "aaleexa");
    }

    public boolean isLongPressedName(String name, String typed) {
        if (name == null || typed == null
                || name.length() == 0 || typed.length() == 0) {
            return false;
        }
        int p1 = 0;
        int p2 = 0;
        while (p2 < typed.length()) {
            if (p1 < name.length() && name.charAt(p1) == typed.charAt(p2)) {
                p1++;
                p2++;
            } else {
                if (p2 != 0 && typed.charAt(p2 - 1) == typed.charAt(p2)) {
                    p2++;
                } else {
                    return false;
                }
            }
        }
        return p1 == name.length();
    }
}
