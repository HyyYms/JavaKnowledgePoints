package com.company.dynamicProxy;


/**
 * @program: 代理模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-28 11:30
 **/
public class ZhangSan implements Person {
    @Override
    public void findLove() {
        System.out.println("张三要求：漂亮美丽");
    }
}
