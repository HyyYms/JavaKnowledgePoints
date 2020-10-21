package com.company;

import java.util.*;

/**
 * @program: 代理模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-09-30 11:04
 **/
public class test {
    public static void main(String[] args) {
        Set<String> test = new TreeSet<>();
        String x = "("+2+3+")*"+4+5+")";
        String a = "12+3+";
        String b = "12+3+";

        test.add(a);
        if (test.add(b)) {
            System.out.println(test+"...");
        }else {
            System.out.println("123");
        }
    }

}
