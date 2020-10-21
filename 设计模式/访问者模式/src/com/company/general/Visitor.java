package com.company.general;

/**
 * @program: 访问者模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-21 16:35
 **/
public interface Visitor {

    void visit(ConcreteElementA element);

    void visit(ConcreteElementB element);
}
