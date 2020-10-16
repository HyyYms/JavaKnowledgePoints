package com.company.general;

//上下文环境
public class Context {
    private Strategy mStrategy;

    public Context(Strategy strategy) {
        this.mStrategy = strategy;
    }

    public void algorithm() {
        this.mStrategy.algorithm();
    }
}