package com.company.v1;

/**
 * @program: 装饰者模式
 * @description: 鸡蛋火腿煎饼
 * @author: Mr.Huang
 * @create: 2020-10-10 23:13
 **/
public class BattercakeWithEggAndSausage extends BattercakeWithEgg {

    @Override
    protected String getMsg() {
        return super.getMsg() + "1个火腿";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 2;
    }
}
