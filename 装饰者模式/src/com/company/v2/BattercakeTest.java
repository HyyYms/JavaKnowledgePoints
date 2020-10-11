package com.company.v2;

/**
 * @program: 装饰者模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-11 11:17
 **/
public class BattercakeTest {
    public static void main(String[] args) {
        Battercake battercake;
        battercake = new BaseBattercake();
        battercake = new EggDecotator(battercake);
        battercake = new SausageDecorator(battercake);
        System.out.println(battercake.getMsg() + "总价" + battercake.getPrice());
    }
}
