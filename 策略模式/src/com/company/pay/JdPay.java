package com.company.pay;

/**
 * @program: 策略模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-16 09:52
 **/
public class JdPay extends Payment {
    @Override
    public String getName() {
        return "京东支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 123;
    }
}
