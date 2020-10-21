package com.company.dynamicProxy;

/**
 * @program: 代理模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-28 23:10
 **/
public class Main {
    public static void main(String[] args) {
        JdkMeipo jdkMeipo = new JdkMeipo();
        Person zhangsan = jdkMeipo.getInstance(new ZhangSan());
        zhangsan.findLove();



        Person lisi = jdkMeipo.getInstance(new LiSi());
        lisi.findLove();
    }
}
