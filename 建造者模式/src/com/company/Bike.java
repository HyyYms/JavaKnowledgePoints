package com.company;

/**
 * @program: 建造者模式
 * @description: 单车类
 * @author: Mr.Huang
 * @create: 2020-09-24 15:48
 **/
public class Bike {
    private String frame;
    private String seat;
    private String tire;

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getTire() {
        return tire;
    }

    public void setTire(String tire) {
        this.tire = tire;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "frame='" + frame + '\'' +
                ", seat='" + seat + '\'' +
                ", tire='" + tire + '\'' +
                '}';
    }
}
