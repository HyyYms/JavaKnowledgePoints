package com.company.integer;

/**
 * @program: 享元模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-14 19:59
 **/
public class Main {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(100);
        Integer b = 100;

        Integer c = Integer.valueOf(1000);
        Integer d = 1000;

        System.out.println("a==b：" + (a == b));
        System.out.println("c==d：" + (c == d));

    }
}
