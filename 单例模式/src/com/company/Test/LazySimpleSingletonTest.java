package com.company.Test;

/**
 * @program: 单例模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-12 11:16
 **/
public class LazySimpleSingletonTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ExcetorThread());
        Thread t2 = new Thread(new ExcetorThread());
        t1.start();
        t2.start();
        System.out.println("End");
    }
}
