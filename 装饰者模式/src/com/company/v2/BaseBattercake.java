package com.company.v2;


/**
 * @program: 装饰者模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-10 23:19
 **/
public class BaseBattercake extends Battercake {
    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 10;
    }
}
