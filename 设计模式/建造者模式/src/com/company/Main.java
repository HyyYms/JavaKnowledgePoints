package com.company;

public class Main {

    public static void main(String[] args) {
        BikeBuilder bikeBuilder = new BikeBuilder()
                .buildFrame("单车框架")
                .buildSeat("单车座椅")
                .buildTire("单车轮胎");

        System.out.println(bikeBuilder.createBike());
    }
}
