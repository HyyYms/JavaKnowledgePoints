package com.company;

/**
 * @program: 桥接模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-15 18:36
 **/
public class NomalMessage extends AbstractMessage{
    public NomalMessage(Message message) {
        super(message);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        super.sendMessage(message, toUser);
    }
}
