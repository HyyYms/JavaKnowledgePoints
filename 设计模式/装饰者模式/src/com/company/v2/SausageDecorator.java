package com.company.v2;

/**
 * @program: 装饰者模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-11 11:16
 **/
public class SausageDecorator extends BattercakeDecotator {
    public SausageDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "1个热狗";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }
}
