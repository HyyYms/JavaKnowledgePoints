package com.company.general;

/**
 * @program: 观察者模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-20 22:53
 **/
public class Test {

    public static void main(String[] args) {
        // 被观察者
        Subject<String> observable = new ConcreteSubject<String>();
        // 观察者
        Observer<String> observer = new ConcreteObserver<String>();
        // 注册
        observable.attach(observer);
        // 通知
        observable.notify("hello");
    }

}
