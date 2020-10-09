package com.company.abstractFactory;

/**
 * @program: 工厂模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-09 20:55
 **/
public class JavaKnowledgeFactory extends KnowledgeFactory{
    @Override
    protected Book createBook() {
        super.init();
        return new JavaBook();
    }

    @Override
    protected Video createVideo() {
        super.init();
        return new JavaVideo();
    }
}
