package com.company.general;

/**
 * @program: 观察者模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-20 22:49
 **/
public interface Subject<E> {

    boolean attach(Observer<E> observer);

    boolean detach(Observer<E> observer);

    void notify(E event);

}
