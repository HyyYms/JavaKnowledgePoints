package com.company.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: 单例模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-12 17:27
 **/
public class ContainerSingleton {
    private ContainerSingleton() {
    }

    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    public static Object getBean(String className) {
        synchronized (ioc) {
            if (!ioc.containsKey(className)) {
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    ioc.put(className, obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            } else {
                return ioc.get(className);
            }
        }
    }
}
