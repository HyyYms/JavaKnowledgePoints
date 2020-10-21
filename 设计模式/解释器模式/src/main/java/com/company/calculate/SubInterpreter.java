package com.company.calculate;

/**
 * @program: 解释器模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-20 17:31
 **/
public class SubInterpreter  extends Interpreter {

    public SubInterpreter(ArithmeticInterpreter left, ArithmeticInterpreter right) {
        super(left, right);
    }

    public int interpret() {
        return this.left.interpret() - this.right.interpret();
    }
}
