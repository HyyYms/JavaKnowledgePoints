package com.company.calculate;

/**
 * @program: 解释器模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-20 17:41
 **/
public class Test {

    public static void main(String[] args) {
        System.out.println("result: " + new Calculator("10 + 30").calculate());
        System.out.println("result: " + new Calculator("10 + 30 - 20").calculate());
        System.out.println("result: " + new Calculator("100 * 2 + 400 - 20 + 66").calculate());
    }

}
