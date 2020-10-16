package com.company.general;

//具体策略类 ConcreteStrategy
public class ConcreteStrategyB implements Strategy {
    @Override
    public void algorithm() {
        System.out.println("Strategy B");
    }
}