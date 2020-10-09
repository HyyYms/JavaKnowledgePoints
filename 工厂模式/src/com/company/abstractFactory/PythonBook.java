package com.company.abstractFactory;

/**
 * @program: 工厂模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-09 16:45
 **/
public class PythonBook implements Book {
    @Override
    public void readBook() {
        System.out.println("阅读Python类书籍");
    }
}
