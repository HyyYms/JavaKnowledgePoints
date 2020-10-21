package com.company.factoryMethod;

/**
 * @program: 工厂模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-09 17:29
 **/
public class FactoryMethodTest {
    public static void main(String[] args) {
        // 分别创建Java类书籍工厂与Python类书籍工厂
        BookFactory javaFactory = new JavaBookFactory();
        BookFactory pythonFactory = new PythonBookFactory();
        // 创建Java书籍类与Python书籍类
        Book javaBook = javaFactory.create();
        Book pythonBook = pythonFactory.create();
        // 调用方法
        javaBook.readBook();
        pythonBook.readBook();
    }
}
