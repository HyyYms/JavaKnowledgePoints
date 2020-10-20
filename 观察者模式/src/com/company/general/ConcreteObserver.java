package com.company.general;


/**
 * @program: 观察者模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-20 22:50
 **/
public class ConcreteObserver<E> implements Observer<E> {

    @Override
    public void update(E event) {
        System.out.println("receive event: " + event);
    }

}
