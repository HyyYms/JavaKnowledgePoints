package com.company.objectAdapter;

/**
 * @program: 适配器模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-15 08:52
 **/
public class Test {
    public static void main(String[] args) {
        DC5 adapter = new PowerAdapter(new AC220());

        adapter.outputDC5V();
    }
}
