package com.company.lazy;

/**
 * @program: 单例模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-12 16:30
 **/
public class LazyInnerClassSingleton {
    private LazyInnerClassSingleton() {
        if (LazyHolder.LAZY != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    public static final LazyInnerClassSingleton getInstance() {
        return LazyHolder.LAZY;
    }

    private static class LazyHolder {
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }
}
