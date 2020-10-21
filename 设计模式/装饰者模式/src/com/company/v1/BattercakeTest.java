package com.company.v1;

/**
 * @program: 装饰者模式
 * @description: 测试代码
 * @author: Mr.Huang
 * @create: 2020-10-10 23:14
 **/
public class BattercakeTest {
    public static void main(String[] args) {
        Battercake battercake = new Battercake();
        System.out.println(battercake.getMsg() + "价格：" + battercake.getPrice());

        BattercakeWithEgg battercakeWithEgg = new BattercakeWithEgg();
        System.out.println(battercakeWithEgg.getMsg() + "价格：" + battercakeWithEgg.getPrice());

        BattercakeWithEggAndSausage battercakeWithEggAndSausage = new BattercakeWithEggAndSausage();
        System.out.println(battercakeWithEggAndSausage.getMsg() + "价格：" + battercakeWithEggAndSausage.getPrice());
    }
}
