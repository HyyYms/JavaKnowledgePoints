package com.company.general;

/**
 * @program: 访问者模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-21 16:36
 **/
public class Test {

    public static void main(String[] args) {
        ObjectStructure collection = new ObjectStructure();
        System.out.println("ConcreteVisitorA handle elements:");
        Visitor visitorA = new ConcreteVisitorA();
        collection.accept(visitorA);
        System.out.println("------------------------------------");
        System.out.println("ConcreteVisitorB handle elements:");
        Visitor visitorB = new ConcreteVisitorB();
        collection.accept(visitorB);
    }

}
