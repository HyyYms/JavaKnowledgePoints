package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: 原型模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-23 17:49
 **/
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        Method method = hungrySingleton.getClass().getDeclaredMethod("clone");
        method.setAccessible(true);
        HungrySingleton cloneHungrySingleton = (HungrySingleton) method.invoke(hungrySingleton);
        System.out.println(hungrySingleton);
        System.out.println(cloneHungrySingleton);
    }
}
