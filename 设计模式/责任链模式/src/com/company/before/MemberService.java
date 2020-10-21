package com.company.before;

/**
 * @program: 责任链模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-16 11:02
 **/
public class MemberService {

    public void login(String loginName, String loginPass) {
        if (loginName.isEmpty() || loginPass.isEmpty()) {
            System.out.println("用户名与密码不可为空");
            return;
        }
        System.out.println("用户名和密码不为空，可进行下一步");

        Member member = checkExists(loginName, loginPass);
        if (null == member) {
            System.out.println("用户不存在");
            return;
        }
        System.out.println("登录成功");

        if (!"管理员".equals(member.getRoleName())) {
            System.out.println("您不是管理员，无操作权限");
            return;
        }
        System.out.println("您是管理员，允许操作");
    }

    private Member checkExists(String loginName, String loginPass) {
        Member member = new Member(loginName, loginPass);
        member.setRoleName("管理员");
        return member;
    }
}
