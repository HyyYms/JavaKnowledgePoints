package com.company.lazy;

/**
 * @program: 单例模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-12 11:05
 **/
public class LazySimpleSingleton {
    private LazySimpleSingleton() {
    }

    private static LazySimpleSingleton lazy = null;

    public static LazySimpleSingleton getInstance() {
        if (lazy == null) {
            synchronized (LazySimpleSingleton.class) {
                if (lazy == null) {
                    lazy = new LazySimpleSingleton();
                }
            }
        }
        return lazy;
    }

//    public synchronized static LazySimpleSingleton getInstance() {
//        if (lazy == null) {
//            lazy = new LazySimpleSingleton();
//        }
//        return lazy;
//    }

//    public static LazySimpleSingleton getInstance() {
//        if (lazy == null) {
//            lazy = new LazySimpleSingleton();
//        }
//        return lazy;
//    }
}
