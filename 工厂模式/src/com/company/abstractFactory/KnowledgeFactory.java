package com.company.abstractFactory;

public abstract class KnowledgeFactory {
    void init() {
        System.out.println("初始化数据");
    }

    protected abstract Book createBook();

    protected abstract Video createVideo();
}
