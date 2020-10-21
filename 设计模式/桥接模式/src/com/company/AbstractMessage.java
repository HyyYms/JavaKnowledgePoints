package com.company;

/**
 * @program: 桥接模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-15 18:32
 **/
public abstract class AbstractMessage {
    Message message;

    public AbstractMessage(Message message) {
        this.message = message;
    }

    public void sendMessage(String message, String toUser) {
        this.message.send(message, toUser);
    }
}
