package com.company.kpi;

import java.util.Random;

/**
 * @program: 访问者模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-21 16:45
 **/
public class Engineer extends Employee {
    public Engineer(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    //考核指标是每年的代码量
    public int getCodeLines() {
        return new Random().nextInt(10 * 10000);
    }
}