package com.company.before;

/**
 * @program: 责任链模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-16 11:09
 **/
public class Test {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();
        memberService.login("huang", "123");
    }
}
