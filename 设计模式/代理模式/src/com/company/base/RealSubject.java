package com.company.base;

/**
 * @program: 代理模式
 * @description: 真实角色
 * @author: Mr.Huang
 * @create: 2020-09-28 10:57
 **/
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("real service is called");
    }
}
