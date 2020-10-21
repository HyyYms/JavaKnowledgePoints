package com.company;

/**
 * @program: 桥接模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-15 17:41
 **/
public class EmailMessage implements Message {

    @Override
    public void send(String message, String toUser) {
        System.out.println(String.format("使用邮件短信息的方法，发送信息%s给%s", message, toUser));
    }

}
