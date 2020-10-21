package com.company.kpi;

import java.util.Random;

/**
 * @program: 访问者模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-21 16:45
 **/
public class Manager extends Employee {
    public Manager(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    //考核的是每年新产品研发数量
    public int getProducts() {
        return new Random().nextInt(10);
    }
}
