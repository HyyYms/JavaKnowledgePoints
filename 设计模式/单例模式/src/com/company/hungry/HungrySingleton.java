package com.company.hungry;

/**
 * @program: 单例模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-12 10:50
 **/
public class HungrySingleton {
    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }
}
