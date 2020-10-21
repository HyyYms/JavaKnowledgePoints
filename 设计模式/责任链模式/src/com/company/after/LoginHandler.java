package com.company.after;

/**
 * @program: 责任链模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-16 11:14
 **/
public class LoginHandler extends Handler {
    @Override
    public void doHandler(Member member) {
        System.out.println("登录成功");
        member.setRoleName("管理员");
        chain.doHandler(member);
    }
}
