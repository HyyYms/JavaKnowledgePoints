package com.company.calculate;

/**
 * @program: 解释器模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-20 17:31
 **/
public class NumInterpreter implements ArithmeticInterpreter {

    private int value;

    public NumInterpreter(int value) {
        this.value = value;
    }


    public int interpret() {
        return this.value;
    }

}
