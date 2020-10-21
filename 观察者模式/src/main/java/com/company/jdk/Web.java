package com.company.jdk;

import java.util.Observable;

/**
 * @program: 观察者模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-21 10:32
 **/
public class Web extends Observable {

    private String name = "提问网站";
    private static final Web web = new Web();

    private Web() {}

    public static Web getInstance(){
        return web;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Question question){
        System.out.println(question.getUserName() + "在" + this.name + "上提交了一个问题。");
        setChanged();
        notifyObservers(question);
    }
}
