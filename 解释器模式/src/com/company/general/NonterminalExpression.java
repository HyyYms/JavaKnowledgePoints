package com.company.general;

/**
 * @program: 解释器模式
 * @description: 非终结符表达式
 * @author: Mr.Huang
 * @create: 2020-10-20 17:24
 **/
public class NonterminalExpression implements Expression{
    private Expression [] expressions;

    public NonterminalExpression(Expression... expressions) {
        // 每个非终结符表达式都会对其他表达式产生依赖
        this.expressions = expressions;
    }


    @Override
    public Object interpret(Context context) {
        // 进行文法处理
        context.put("","");
        return null;
    }
}
