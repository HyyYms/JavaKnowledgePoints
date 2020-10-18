package com.company;

/**
 * @program: 状态模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-18 16:09
 **/
public class LoginState extends UserState {
    @Override
    public void favorite() {
        System.out.println("收藏成功");
    }

    @Override
    public void comment(String comment) {
        System.out.println(comment);
    }
}
