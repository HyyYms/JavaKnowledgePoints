package com.company.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * @program: 观察者模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-21 10:32
 **/
public class Teacher implements Observer {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public void update(Observable o, Object arg) {
        Web web = (Web)o;
        Question question = (Question)arg;
        System.out.println("======================");
        System.out.println(name + "老师，你好！\n" +
                "您收到了一个来自" + web.getName() + "的提问，希望您解答。问题内容如下：\n" +
                question.getContent() + "\n" +
                "提问者：" + question.getUserName());
    }
}
