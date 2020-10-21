package com.company.v1;

/**
 * @program: 装饰者模式
 * @description: 鸡蛋煎饼
 * @author: Mr.Huang
 * @create: 2020-10-10 23:12
 **/
public class BattercakeWithEgg extends Battercake {

    @Override
    protected String getMsg() {
        return super.getMsg() + "1个鸡蛋";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
