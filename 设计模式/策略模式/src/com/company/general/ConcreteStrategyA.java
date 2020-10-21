package com.company.general;

//具体策略类 ConcreteStrategy
public class ConcreteStrategyA implements Strategy {
    @Override
    public void algorithm() {
        System.out.println("Strategy A");
    }
}