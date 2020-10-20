package com.company.general;

/**
 * @program: 解释器模式
 * @description: 抽象表达式
 * @author: Mr.Huang
 * @create: 2020-10-20 17:23
 **/
public interface Expression {

    // 对表达式进行解释
    Object interpret(Context context);
}
