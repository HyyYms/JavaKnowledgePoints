package com.company;

/**
 * @program: 中介者模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-19 16:47
 **/
public class ConcreteMediator extends Mediator{
    @Override
    public void transferA() {
        // 协调行为:A 转发到 B
        this.colleagueB.selfMethodB();
    }

    @Override
    public void transferB() {
        // 协调行为:B 转发到 A
        this.colleagueA.selfMethodA();
    }
}
