package com.company.abstractFactory;

/**
 * @program: 工厂模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-09 20:57
 **/
public class AbstractFactoryTest {
    public static void main(String[] args) {
        JavaKnowledgeFactory javaFactory = new JavaKnowledgeFactory();
        javaFactory.createBook().readBook();
        javaFactory.createVideo().watchVideo();

        PythonKnowledgeFactory pythonFactory = new PythonKnowledgeFactory();
        pythonFactory.createBook().readBook();
        pythonFactory.createVideo().watchVideo();
    }
}
