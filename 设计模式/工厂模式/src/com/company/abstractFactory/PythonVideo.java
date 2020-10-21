package com.company.abstractFactory;

/**
 * @program: 工厂模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-09 17:57
 **/
public class PythonVideo implements Video{
    @Override
    public void watchVideo() {
        System.out.println("观看Python类视频");
    }
}
