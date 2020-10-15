package com.company.interfaceAdapter;


/**
 * @program: 适配器模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-15 08:52
 **/
public class Test {
    public static void main(String[] args) {
        DC adapter = new PowerAdapter(new AC220());

        adapter.output5V();
    }
}
