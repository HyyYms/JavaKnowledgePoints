package com.company.after;

/**
 * @program: 责任链模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-16 11:15
 **/
public class AuthHandler extends Handler{
    @Override
    public void doHandler(Member member) {
        if (!"管理员".equals(member.getRoleName())){
            System.out.println("您不是管理员，无操作权限");
            return;
        }
        System.out.println("您是管理员，允许操作");
    }
}
