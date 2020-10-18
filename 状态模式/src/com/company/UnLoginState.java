package com.company;

/**
 * @program: 状态模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-18 16:09
 **/
public class UnLoginState extends UserState {

    @Override
    public void favorite() {
        this.switchToLogin();
        this.context.getCurrentState().favorite();
    }


    @Override
    public void comment(String comment) {
        this.switchToLogin();
        this.context.getCurrentState().comment(comment);
    }

    private void switchToLogin() {
        System.out.println("跳转到登录页面");
        this.context.setCurrentState(AppContext.STATE_LOGIN);
    }
}
