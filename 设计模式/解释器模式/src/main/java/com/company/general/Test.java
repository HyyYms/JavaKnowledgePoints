package com.company.general;

import java.util.Stack;

/**
 * @program: 解释器模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-20 17:26
 **/
public class Test {

    public static void main(String[] args) {
        try {
            Context context = new Context();
            // 定义一个语法容器，用于存储一个具体表达式
            Stack<Expression> stack = new Stack<Expression>();
//            for (; ; ) {
//                // 进行语法解析，并产生递归调用
//            }
            // 获取得到最终的解析表达式：完整语法树
            Expression expression = stack.pop();
            // 递归调用获取结果
            expression.interpret(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
