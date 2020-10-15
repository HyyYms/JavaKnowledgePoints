package com.company.demo;

/**
 * @program: 模板方法模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-15 21:35
 **/
public class Test {
    public static void main(String[] args) {
        System.out.println("====A====");
        ACook a = new ACook();
        a.setNeedWash(true);
        a.create();

        System.out.println("====B====");
        BCook b = new BCook();
        b.create();
    }
}
