package com.company;

/**
 * @program: 状态模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-18 16:08
 **/
public class AppContext {

    public static final UserState STATE_LOGIN = new LoginState();
    public static final UserState STATE_UNLOGIN = new UnLoginState();
    private UserState currentState = STATE_UNLOGIN;

    {
        STATE_LOGIN.setContext(this);
        STATE_UNLOGIN.setContext(this);
    }

    public AppContext(UserState currentState) {
        this.currentState = currentState;
        this.currentState.setContext(this);
    }

    public UserState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(UserState currentState) {
        this.currentState = currentState;
    }

    public void favorite() {
        this.currentState.favorite();
    }

    public void comment(String comment) {
        this.currentState.comment(comment);
    }

    public AppContext() {
    }
}
