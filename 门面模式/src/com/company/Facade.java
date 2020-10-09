package com.company;

/**
 * @program: 门面模式
 * @description: 外观角色
 * @author: Mr.Huang
 * @create: 2020-10-09 15:51
 **/
public class Facade {
    private SubSystemA a = new SubSystemA();
    private SubSystemB b = new SubSystemB();
    private SubSystemC c = new SubSystemC();

    public void methodA() {
        this.a.methodA();
    }

    public void methodB() {
        this.b.methodB();
    }

    public void methodC() {
        this.c.methodC();
    }
}
