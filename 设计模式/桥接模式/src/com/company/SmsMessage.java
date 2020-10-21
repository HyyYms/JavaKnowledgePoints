package com.company;

/**
 * @program: 桥接模式
 * @description: 手机短信
 * @author: Mr.Huang
 * @create: 2020-10-15 17:44
 **/

public class SmsMessage implements Message {

    @Override
    public void send(String message, String toUser) {
        System.out.println(String.format("使用短信服务的方法，发送信息%s给%s", message, toUser));
    }

}
