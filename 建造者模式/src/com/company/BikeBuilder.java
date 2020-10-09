package com.company;

/**
 * @program: 建造者模式
 * @description: 单车建造类
 * @author: Mr.Huang
 * @create: 2020-09-24 16:03
 **/
public class BikeBuilder {
    private Bike bike = new Bike();

    public BikeBuilder buildFrame(String frame) {
        bike.setFrame(frame);
        return this;
    }

    public BikeBuilder buildSeat(String seat) {
        bike.setSeat(seat);
        return this;
    }

    public BikeBuilder buildTire(String tire) {
        bike.setTire(tire);
        return this;
    }

    public Bike createBike() {
        return bike;
    }
}
