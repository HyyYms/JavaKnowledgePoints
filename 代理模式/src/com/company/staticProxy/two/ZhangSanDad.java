package com.company.staticProxy.two;

/**
 * @program: 代理模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-28 11:31
 **/
public class ZhangSanDad implements Person {
    private ZhangSan zhangSan;

    public ZhangSanDad(ZhangSan zhangSan) {
        this.zhangSan = zhangSan;
    }

    @Override
    public void findLove() {
        before();
        zhangSan.findLove();
        after();
    }

    private void after() {
        System.out.println("挑选人员");
    }

    private void before() {
        System.out.println("开始约会");
    }
}
