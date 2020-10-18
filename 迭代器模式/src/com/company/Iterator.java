package com.company;

/**
 * @program: 迭代器模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-18 09:38
 **/
public interface Iterator<E> {

    E next();

    boolean hasNext();
}
