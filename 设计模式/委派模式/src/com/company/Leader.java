package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: 委派模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-15 19:39
 **/
public class Leader implements Employee {

    private Map<String, Employee> employees = new HashMap<>();

    public Leader() {
        employees.put("PPT", new EmployeeA());
        employees.put("Word", new EmployeeB());
    }


    @Override
    public void doing(String task) {
        if (!employees.containsKey(task)) {
            System.out.println("无法完成");
            return;
        }
        employees.get(task).doing(task);
    }
}
