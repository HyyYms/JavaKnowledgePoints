package com.company.staticProxy.one;

/**
 * @program: 代理模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-28 11:25
 **/
public class BaiShiWorker implements Express{
    @Override
    public void sendPackage() {
        System.out.println("寄百世快递");
    }
}
