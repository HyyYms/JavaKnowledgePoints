package com.company;

/**
 * @program: 享元模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-14 11:54
 **/
public class TicketFactory {

    public static Ticket queryTicket(String from, String to) {
        return new TrainTicket(from, to);
    }
}
