package com.company.jdk;

/**
 * @program: 观察者模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-21 10:35
 **/
public class Test {

    public static void main(String[] args) {
        Web web = Web.getInstance();
        Teacher tom = new Teacher("A");
        Teacher jerry = new Teacher("B");

        web.addObserver(tom);
        web.addObserver(jerry);

        //用户行为
        Question question = new Question();
        question.setUserName("张三");
        question.setContent("观察者模式适用于哪些场景？");

        web.publishQuestion(question);
    }

}
