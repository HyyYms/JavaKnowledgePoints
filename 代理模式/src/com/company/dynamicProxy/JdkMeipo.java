package com.company.dynamicProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: 代理模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-28 22:51
 **/
public class JdkMeipo implements InvocationHandler {
    private Person target;

    public Person getInstance(Person target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return (Person) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        System.out.println(proxy.getClass().getName());
        System.out.println(method.getClass().getName());
        System.out.println(args);
        Object result = method.invoke(this.target, args);
        after();
        return result;
    }

    private void after() {
        System.out.println("开始交往");
    }

    private void before() {
        System.out.println("开始物色");
    }
}
