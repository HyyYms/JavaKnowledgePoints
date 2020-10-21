package com.company.pay;

import java.util.HashMap;

import java.util.Map;

/**
 * @program: 策略模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-16 09:53
 **/
public class PayStrategy {
    public static final String ALI_PAY = "AliPay";
    public static final String JD_PAY = "JdPay";
    public static final String WECHAT_PAY = "WeChatPay";
    public static final String DEFAULT_PAY = "WeChatPay";

    private static Map<String, Payment> strategy = new HashMap<String, Payment>();

    static {
        strategy.put(ALI_PAY, new AliPay());
        strategy.put(JD_PAY, new JdPay());
        strategy.put(WECHAT_PAY, new WeChatPay());
    }

    public static Payment get(String payKey) {
        if (!strategy.containsKey(payKey)) {
            return strategy.get(DEFAULT_PAY);
        }
        return strategy.get(payKey);
    }
}
