package com.company;

/**
 * @program: 委派模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-15 19:43
 **/
public class Boss {

    public void command(String task, Leader leader) {
        leader.doing(task);
    }

}
