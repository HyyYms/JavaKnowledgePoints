package com.company.staticProxy.one;

/**
 * @program: 代理模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-28 11:16
 **/
public class ZhongTongExpress implements Express{

    private ZhongTongWorker zhongTongWorker;

    public ZhongTongExpress(ZhongTongWorker zhongTongWorker) {
        this.zhongTongWorker = zhongTongWorker;
    }

    @Override
    public void sendPackage() {
        before();
        zhongTongWorker.sendPackage();
        after();
    }

    private void after() {
        System.out.println("快递到达");
    }

    private void before() {
        System.out.println("挑拣快递");
    }
}
