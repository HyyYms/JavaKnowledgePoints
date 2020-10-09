package com.company;

import java.io.Serializable;

/**
 * @program: 原型模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-23 17:48
 **/
public class HungrySingleton implements Serializable, Cloneable {
    private final static HungrySingleton hungrySingleton;

    static {
        hungrySingleton = new HungrySingleton();
    }

    private HungrySingleton() {
        if (hungrySingleton != null) {
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    private Object readResolve() {
        return hungrySingleton;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return hungrySingleton;
    }
}
