package com.company.factoryMethod;

/**
 * @program: 工厂模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-09 17:30
 **/
public class PythonBookFactory implements BookFactory {
    @Override
    public Book create() {
        return new PythonBook();
    }
}
