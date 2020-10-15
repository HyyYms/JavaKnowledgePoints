package com.company;

/**
 * @program: 桥接模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-15 18:36
 **/
public class UragencyMessage extends AbstractMessage {

    public UragencyMessage(Message message) {
        super(message);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        message = "紧急" + message;
        super.sendMessage(message, toUser);
    }

}
