package com.company.Test;

import com.company.lazy.LazySimpleSingleton;

/**
 * @program: 单例模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-12 11:15
 **/
public class ExcetorThread implements Runnable {
    @Override
    public void run() {
        LazySimpleSingleton simpleSingleton = LazySimpleSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + simpleSingleton);
    }
}
