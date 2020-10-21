package com.company;

/**
 * @program: 中介者模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-19 16:47
 **/
public abstract class Mediator {

    protected ConcreteColleagueA colleagueA;
    protected ConcreteColleagueB colleagueB;

    public void setColleageA(ConcreteColleagueA colleague) {
        this.colleagueA = colleague;
    }

    public void setColleageB(ConcreteColleagueB colleague) {
        this.colleagueB = colleague;
    }

    // 中介者业务逻辑
    public abstract void transferA();

    public abstract void transferB();
}
