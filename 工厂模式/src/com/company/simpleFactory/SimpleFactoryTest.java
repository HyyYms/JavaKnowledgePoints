package com.company.simpleFactory;

/**
 * @program: 工厂模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-09 16:48
 **/
public class SimpleFactoryTest {
    public static void main(String[] args) {
        BookFactory bookFactory = new BookFactory();
        // 使用字符串
//        Book book = bookFactory.createBook("Java").showBook();
        // 使用反射——类名
//        Book book = bookFactory.createBook("com.company.simpleFactory.JavaBook");
        // 使用反射——类
        Book book = bookFactory.createBook(JavaBook.class);
        book.readBook();

//        Book javaBook = new JavaBook();
//        javaBook.readBook();
    }
}
