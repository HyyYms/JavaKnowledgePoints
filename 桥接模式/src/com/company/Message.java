package com.company;

/**
 * @program: 桥接模式
 * @description: 实现消息发送的统一接口
 * @author: Mr.Huang
 * @create: 2020-10-15 17:40
 **/
public interface Message {

    void send(String message, String toUser);
}
