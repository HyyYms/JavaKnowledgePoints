package com.company.calculate;

/**
 * @program: 解释器模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-20 17:30
 **/
public abstract class Interpreter implements ArithmeticInterpreter{

    protected ArithmeticInterpreter left;
    protected ArithmeticInterpreter right;

    public Interpreter(ArithmeticInterpreter left, ArithmeticInterpreter right) {
        this.left = left;
        this.right = right;
    }
}
