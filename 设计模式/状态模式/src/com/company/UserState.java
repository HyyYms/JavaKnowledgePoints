package com.company;

/**
 * @program: 状态模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-18 16:08
 **/
public abstract class UserState {

    protected AppContext context;

    public void setContext(AppContext context){
        this.context = context;
    }

    public abstract void favorite();

    public abstract void comment(String comment);
}
