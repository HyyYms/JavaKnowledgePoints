package com.company.calculate;

/**
 * @program: 解释器模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-20 17:32
 **/
public class OperatorUtil {

    public static boolean isOperator(String symbol) {
        return ("+".equals(symbol) || "-".equals(symbol) || "*".equals(symbol));
    }

    public static Interpreter getInterpreter(ArithmeticInterpreter left, ArithmeticInterpreter right, String symbol) {
        if ("+".equals(symbol)) {
            return new AddInterpreter(left, right);
        } else if ("-".equals(symbol)) {
            return new SubInterpreter(left, right);
        } else if ("*".equals(symbol)) {
            return new MultiInterpreter(left, right);
        } else if ("/".equals(symbol)) {
            return new DivInterpreter(left, right);
        }
        return null;
    }

}
