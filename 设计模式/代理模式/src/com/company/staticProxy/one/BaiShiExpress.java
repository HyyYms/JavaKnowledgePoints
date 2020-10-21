package com.company.staticProxy.one;

/**
 * @program: 代理模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-28 11:25
 **/
public class BaiShiExpress implements Express{
    private BaiShiWorker baiShiWorker;

    public BaiShiExpress(BaiShiWorker baiShiWorker) {
        this.baiShiWorker = baiShiWorker;
    }

    @Override
    public void sendPackage() {
        before();
        baiShiWorker.sendPackage();
        after();
    }

    private void after() {
        System.out.println("快递到达");
    }

    private void before() {
        System.out.println("挑拣快递");
    }
}
