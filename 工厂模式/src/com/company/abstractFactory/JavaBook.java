package com.company.abstractFactory;

/**
 * @program: 工厂模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-09 16:44
 **/
public class JavaBook implements Book {
    @Override
    public void readBook() {
        System.out.println("阅读Java类书本");
    }
}
