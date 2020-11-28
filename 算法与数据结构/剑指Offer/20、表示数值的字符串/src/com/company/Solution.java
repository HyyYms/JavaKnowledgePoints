package com.company;

/**
 * @program: 20、表示数值的字符串
 * @description:
 * * 正负号只能在开头或者是e/E的后面
 * * 小数点不能重复出现
 * * e/E不能重复出现
 * * e/E不能出现在小数点前
 * * e/E的前面与后面必须有整数
 * * 小数点前面可以没有整数
 * @author: Mr.Huang
 * @create: 2020-11-28 22:10
 **/
public class Solution {

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean isNumber = false, isDot = false, isE = false;
        char[] chars = s.trim().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 字符为数字，数字标识变为true
            if (chars[i] >= '0' && chars[i] <= '9') {
                isNumber = true;
            }
            // 字符为小数点，如果已经重复小数点或E出现在小数点前面则为违法
            else if (chars[i] == '.') {
                if (isDot || isE) {
                    return false;
                }
                isDot = true;
            }
            // 字符为E，如果前面未出现整数或重复出现E则违法
            else if (chars[i] == 'e' || chars[i] == 'E') {
                if (!isNumber || isE) {
                    return false;
                }
                isE = true;
                isNumber = false;
            }
            // 符合只能在开头或者是E后面
            else if (chars[i] == '+' || chars[i] == '-') {
                if (i != 0 && chars[i - 1] != 'e' && chars[i - 1] != 'E') {
                    return false;
                }
            }
            // 其余字符为违法字符
            else {
                return false;
            }
        }
        // 判断整数标识
        return isNumber;
    }
}
