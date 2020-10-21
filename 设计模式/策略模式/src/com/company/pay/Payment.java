package com.company.pay;

/**
 * @program: 策略模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-16 09:47
 **/
public abstract class Payment {

    public abstract String getName();

    public MsgResult pay(String uid, double amount) {
        if (queryBalance(uid) < amount) {
            return new MsgResult(500, "支付失败", "余额不足");
        }
        return new MsgResult(200, "支付成功", "交易成功，交易金额：" + amount);
    }

    protected abstract double queryBalance(String uid);
}
