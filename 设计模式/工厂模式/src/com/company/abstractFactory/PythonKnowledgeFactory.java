package com.company.abstractFactory;

/**
 * @program: 工厂模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-09 20:56
 **/
public class PythonKnowledgeFactory extends KnowledgeFactory{
    @Override
    protected Book createBook() {
        super.init();
        return new PythonBook();
    }

    @Override
    protected Video createVideo() {
        super.init();
        return new PythonVideo();
    }
}
