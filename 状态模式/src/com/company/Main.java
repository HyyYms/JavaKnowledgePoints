package com.company;

public class Main {

    public static void main(String[] args) {
        // 默认不传值为未登录
        AppContext appContext = new AppContext();
        appContext.favorite();
        appContext.comment("评论成功");
    }
}
