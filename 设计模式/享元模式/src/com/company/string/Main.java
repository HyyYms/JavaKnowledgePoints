package com.company.string;

/**
 * @program: 享元模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-14 15:37
 **/
public class Main {
    public static void main(String[] args) {

        // s1与s2的赋值皆为常量
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2);

        // s3的赋值为常量，s4的赋值为常量加变量
        String s3 = "he" + "llo";
        String s4 = "he" + new String("llo");
        System.out.println(s3 == s4);

        // s5的赋值为变量，s6的赋值为intern()方法
        String s5 = new String("hello");
        String s6 = s5.intern();
        System.out.println(s5 == s6);

        // s1的赋值为常量，s6的赋值为intern()方法
        System.out.println(s1 == s6);
    }
}
