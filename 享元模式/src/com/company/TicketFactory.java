package com.company;

import java.util.concurrent.ConcurrentHashMap;

import java.util.Map;

/**
 * @program: 享元模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-14 11:54
 **/
public class TicketFactory {

    private static Map<String, Ticket> ticketPool = new ConcurrentHashMap<String, Ticket>();

    public static Ticket queryTicket(String from, String to) {
        String key = from + "->" + to;
        if (TicketFactory.ticketPool.containsKey(key)) {
            System.out.println("使用缓存");
            return TicketFactory.ticketPool.get(key);
        }
        System.out.println("首次查询，创建对象：" + key);
        Ticket ticket = new TrainTicket(from, to);
        TicketFactory.ticketPool.put(key, ticket);
        return ticket;
    }
}
