package com.company.pay;

/**
 * @program: 策略模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-16 10:04
 **/
public class Test {
    public static void main(String[] args) {
        Order order = new Order("123", "234345345", 234);
        System.out.println(order.pay(PayStrategy.WECHAT_PAY));
    }
}
