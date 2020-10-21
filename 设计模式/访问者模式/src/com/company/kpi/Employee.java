package com.company.kpi;

import java.util.Random;

/**
 * @program: 访问者模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-21 16:44
 **/
public abstract class Employee {

    public String name;
    public int kpi;  //员工KPI

    public Employee(String name) {
        this.name = name;
        kpi = new Random().nextInt(10);
    }

    //接收访问者的访问
    public abstract void accept(Visitor visitor);
}