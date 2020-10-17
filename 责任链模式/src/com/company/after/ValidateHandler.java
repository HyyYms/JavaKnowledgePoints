package com.company.after;

/**
 * @program: 责任链模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-16 11:13
 **/
public class ValidateHandler extends Handler {
    @Override
    public void doHandler(Member member) {
        if (member.getLoginName().isEmpty() || member.getLoginPass().isEmpty()) {
            System.out.println("用户名或密码为空");
            return;
        }
        System.out.println("用户名与密码不为空，可进行下一步");
        chain.doHandler(member);
    }
}
