package com.company;

//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
//         
//
//        示例 1：
//
//        输入：s = "We are happy."
//        输出："We%20are%20happy."
//         

public class Main {

    public static void main(String[] args) {
        String s = "We are happy.";
        s = replaceSpace(s);
        System.out.println(s);
    }

    public static String myReplaceSpace(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (" ".equals(s.substring(i, i + 1))) {
                s = s.substring(0, i) + "%20" + s.substring(i + 1);
            }
        }
        return s;
    }


    public static String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == ' ') {
                res.append("%20");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }


}
