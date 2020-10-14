package com.company;

import java.util.Random;

/**
 * @program: 享元模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-14 11:51
 **/
public class TrainTicket implements Ticket {

    private String from;
    private String to;
    private int price;

    public TrainTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void showInfo(String bunk) {
        this.price = new Random().nextInt(500);
        System.out.println(
                String.format("%s->%s：%s 价格：%s 元", this.from, this.to, bunk, this.price)
        );
    }
}
