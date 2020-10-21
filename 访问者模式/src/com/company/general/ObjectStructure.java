package com.company.general;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: 访问者模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-21 16:36
 **/
public class ObjectStructure {

    private List<Element> list = new ArrayList<Element>();

    {
        this.list.add(new ConcreteElementA());
        this.list.add(new ConcreteElementB());
    }

    public void accept(Visitor visitor) {
        for (Element element : this.list) {
            element.accept(visitor);
        }
    }
}
