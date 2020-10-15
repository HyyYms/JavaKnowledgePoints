package com.company;

/**
 * @program: 委派模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-15 19:39
 **/
public class EmployeeA implements Employee {

    protected String goodAt = "PPT";

    @Override
    public void doing(String task) {
        System.out.println("员工A，擅长做：" + goodAt + "正在做：" + task);
    }
}
