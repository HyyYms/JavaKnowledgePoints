package com.company.staticProxy.two;

/**
 * @program: 代理模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-28 11:31
 **/
public class LiSiDad implements Person {
    private LiSi liSi;

    public LiSiDad(LiSi liSi) {
        this.liSi = liSi;
    }

    @Override
    public void findLove() {
        before();
        liSi.findLove();
        after();
    }

    private void after() {
        System.out.println("挑选人员");
    }

    private void before() {
        System.out.println("开始约会");
    }
}
