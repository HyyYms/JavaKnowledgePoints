package com.company.general;

/**
 * @program: 解释器模式
 * @description: 终结符表达式
 * @author: Mr.Huang
 * @create: 2020-10-20 17:24
 **/
public class TerminalExpression implements Expression{

    private Object value;

    public Object interpret(Context context) {
        // 实现文法中与终结符有关的操作
        context.put("","");
        return null;
    }
}
