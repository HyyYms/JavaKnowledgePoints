package com.company;

/**
 * @program: 委派模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-15 19:39
 **/
public class EmployeeB implements Employee {

    protected String goodAt = "Word";

    @Override
    public void doing(String task) {
        System.out.println("员工A，擅长做：" + goodAt + "正在做：" + task);
    }
}
