package com.company.v2;

/**
 * @program: 装饰者模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-11 11:14
 **/
public class EggDecotator extends BattercakeDecotator {

    public EggDecotator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "1个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 1;
    }
}
