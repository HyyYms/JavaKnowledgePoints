package com.company;

/**
 * @program: 中介者模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-19 16:47
 **/
public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
