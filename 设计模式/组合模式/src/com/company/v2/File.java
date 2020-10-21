package com.company.v2;

/**
 * @program: 组合模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-14 21:22
 **/
public class File extends Directory{
    public File(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println(this.name);
    }
}
