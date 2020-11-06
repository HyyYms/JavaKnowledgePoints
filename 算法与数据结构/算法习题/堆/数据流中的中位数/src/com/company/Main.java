package com.company;

public class Main {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        double median = medianFinder.findMedian();
        medianFinder.addNum(3);
        double median1 = medianFinder.findMedian();
    }
}
