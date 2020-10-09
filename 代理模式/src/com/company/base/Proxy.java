package com.company.base;

/**
 * @program: 代理模式
 * @description: 代理角色
 * @author: Mr.Huang
 * @create: 2020-09-28 10:58
 **/
public class Proxy implements Subject {

    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        before();
        subject.request();
        after();
    }

    private void after() {
    }

    private void before() {
    }
}
