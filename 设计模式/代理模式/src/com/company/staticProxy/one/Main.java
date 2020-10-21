package com.company.staticProxy.one;

/**
 * @program: 代理模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-28 11:22
 **/
public class Main {
    public static void main(String[] args) {
        ZhongTongExpress ztExpress = new ZhongTongExpress(new ZhongTongWorker());
        ztExpress.sendPackage();

        BaiShiExpress bsExpress = new BaiShiExpress(new BaiShiWorker());
        bsExpress.sendPackage();
    }
}
