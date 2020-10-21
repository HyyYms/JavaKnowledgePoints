package com.company.kpi;

/**
 * @program: 访问者模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-21 16:44
 **/
public interface Visitor {

    void visit(Engineer engineer);

    void visit(Manager manager);

}
