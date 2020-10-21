package com.company.staticProxy.two;

/**
 * @program: 代理模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-28 11:34
 **/
public class Main {
    public static void main(String[] args) {
        LiSiDad liSiDad = new LiSiDad(new LiSi());
        liSiDad.findLove();

        ZhangSanDad zhangSanDad = new ZhangSanDad(new ZhangSan());
        zhangSanDad.findLove();
    }
}
