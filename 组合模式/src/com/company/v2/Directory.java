package com.company.v2;

/**
 * @program: 组合模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-14 21:22
 **/
public abstract class Directory {

    protected String name;

    public Directory(String name) {
        this.name = name;
    }

    public abstract void show();
}
