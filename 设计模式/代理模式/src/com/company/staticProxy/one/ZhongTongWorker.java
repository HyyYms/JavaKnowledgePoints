package com.company.staticProxy.one;

/**
 * @program: 代理模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-28 11:14
 **/
public class ZhongTongWorker implements Express {
    @Override
    public void sendPackage() {
        System.out.println("寄中通快递");
    }
}
