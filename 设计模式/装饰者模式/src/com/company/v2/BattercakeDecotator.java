package com.company.v2;

/**
 * @program: 装饰者模式
 * @description: 抽象装饰器
 * @author: Mr.Huang
 * @create: 2020-10-10 23:20
 **/
public abstract class BattercakeDecotator extends Battercake {

    private Battercake battercake;

    public BattercakeDecotator(Battercake battercake) {
        this.battercake = battercake;
    }

    protected abstract void doSomething();

    @Override
    protected String getMsg() {
        return this.battercake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.battercake.getPrice();
    }
}
