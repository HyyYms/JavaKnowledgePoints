package com.company.general;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: 观察者模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-20 22:50
 **/
public class ConcreteSubject<E> implements Subject<E> {

    private List<Observer<E>> observers = new ArrayList<Observer<E>>();

    @Override
    public boolean attach(Observer<E> observer) {
        return !this.observers.contains(observer) && this.observers.add(observer);
    }

    @Override
    public boolean detach(Observer<E> observer) {
        return this.observers.remove(observer);
    }

    @Override
    public void notify(E event) {
        for (Observer<E> observer : this.observers) {
            observer.update(event);
        }
    }

}
